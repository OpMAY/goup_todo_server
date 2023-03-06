package com.service.kream.product;

import com.dao.*;
import com.model.kream.DATE_RANGE_TYPE;
import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.Order;
import com.model.kream.order.after.PRODUCT_TRANSACTION_RESULT;
import com.model.kream.order.before.Purchase;
import com.model.kream.order.before.Sell;
import com.model.kream.order.before.sub.purchase.PURCHASE_TYPE;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import com.model.kream.product.Product;
import com.model.kream.product.ProductDetail;
import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.model.kream.product.interactions.PRODUCT_TRANSACTION_TYPE;
import com.model.kream.product.price.ProductPriceHistories;
import com.model.kream.product.price.ProductPriceWithSize;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.product.size.Size;
import com.response.Message;
import com.service.BootPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
    private final BootPayService bootPayService;
    private final ProductDao productDao;
    private final UserDao userDao;
    private final OrderDao orderDao;
    private final SellDao sellDao;
    private final PurchaseDao purchaseDao;
    private final BrandDao brandDao;
    private final StyleDao styleDao;
    private final WishDao wishDao;
    private final SizeDao sizeDao;

    /**
     * TODO 0302 오후
     * 1. Sell / Purchase / Order 등록 O
     * 2. Product Filter (Multi-Select 가능)
     *    - 검색어
     *    - 카테고리
     *    - 브랜드
     *    - 성별
     *    - 신발 사이즈
     *    - 의류 사이즈
     *    - 가격
     *    product
     *      - en_name LIKE
     *      - kor_name LIKE
     *      - brand_no WHERE IN
     *      - gender WHERE IN
     *      - category shoe -> size
     *      - category cloth -> size
     *      - price range -> 최소 즉시 구매가 기준 (즉시 구매가 측정 불가면 뜨지 않음)
     *    ORDERING
     *      - 인기순 -> 판매량 많은 순
     *      - 프리미엄 높은 순
     *          - 출고가 대비 높은 금액에 팔리는 순
     *      - 프리미엄 낮은 순
     *          - 출고가 대비 낮은 금액에 팔리는 순
     *      - 즉시 구매가 낮은/높은 순
     *      - 발매일 순
     * **/
    public List<ProductShop> searchProductWithFilters(List<Integer> brand_list,
                                                      List<Integer> gender_list,
                                                      List<Integer> category_list,
                                                      String keyword,
                                                      List<String> size_list,
                                                      Integer user_no) {
        // TODO ordering filter
        boolean filtered = !brand_list.isEmpty()
                || !gender_list.isEmpty()
                || !category_list.isEmpty()
                || keyword != null
                || !size_list.isEmpty();
        List<ProductShop> result = productDao.searchProductWithFilters(filtered, brand_list, gender_list, category_list, keyword, size_list);
        result.forEach(product -> {
            product.setBrand(brandDao.getBrandByProductNo(product.getNo()));
            product.set_wish(wishDao.isUserWishProduct(product.getNo(), user_no));
            product.setPrice(productDao.getProductLowestSellPrice(product.getNo()).getPrice());
            product.setWishes(wishDao.getProductWishCount(product.getNo()));
//            product.setStyles(styleDao.getProductStyleCount(product.getNo()));
//            product.setOrders(orderDao.getProductOrderCount(product.getNo()));
        });
        return result;
    }


    /**
     * 판매 입찰 등록
     * 0. Product Validation
     * -> product_yn flag check
     * 1. 판매 입찰 정보 확인
     * - SELL_TYPE
     * -> 즉시 판매 OR 판매 입찰
     * -> 즉시 판매 시 해당 거래 조건과 맞는 구매 입찰 내역 확인
     * -> 없으면? false
     * -> 있으면 바로 order 생성
     * -> 판매 입찰 시
     * -> 해당 입찰과 조건이 맞는 구매 입찰이 있는지 확인
     * -> 있다면 즉시 판매와 동일하게 로직
     * -> 없다면 등록
     * - pricing
     * -> 가격 정보 모두 확인
     * - price + inspection_price + delivery_price + commission = total_price ?
     * - 필수 정보
     * -> bank_info, recall_infos, agrees => null check
     * 2. 유저 정보 확인
     * - 기본 유저 관련 예외처리
     **/
    @Transactional
    public Message registerProductSell(Sell sell) {
        Message message = new Message();
        boolean pricing_check = sell.getTotal_price() == sell.getPrice() + sell.getInspection_price() + sell.getDelivery_price() + sell.getCommission();
        boolean required_info_check = (sell.getBank_info() != null
                && sell.getRecall_address_info() != null
                && sell.getRecall_method() != null
                && sell.getSell_agree() != null
                && sell.getS_order_agree() != null);

        Product product = productDao.getProductBySizeNo(sell.getSize_no());
        if (product != null && product.isProduct_yn()) {
            // Check all booleans
            if (pricing_check && required_info_check) {
                /**
                 * 조건 (DB 검증)
                 * 1. 가격 및 사이즈 동일
                 * 2. 구매 입찰이 유효한 상황
                 *    - 거래 연결이 되지 않음
                 *    - 입찰 기한이 만료되지 않음
                 *    - 구매 입찰을 신청한 유저에 대한 예외처리
                 * 3. 동일한 가격의 입찰이 있는 경우의 우선순위
                 *    - 구매 입찰을 가장 먼저 등록한 순서로
                 * **/
                Purchase purchase = purchaseDao.getPurchaseForOrder(sell.getSize_no(), sell.getPrice());
                if (sell.getSell_type().equals(SELL_TYPE.DIRECT)) {
                    if (purchase != null) {
                        // Sell Register
                        sell.setExpiration_days(0);
                        sell.setExpiration_date(LocalDate.now());
                        sellDao.registerSell(sell);
                        // Order Register
                        Order order = new Order(
                                sell.getNo(),
                                purchase.getNo(),
                                "",
                                ORDER_STATUS.REGISTERED,
                                true
                        );
                        orderDao.registerOrder(order);
                        message.put("status", true);
                        message.put("result_type", PRODUCT_TRANSACTION_RESULT.ORDER_CREATED);
                        message.put("order_no", order.getNo());
                    } else {
                        message.put("status", false);
                    }
                } else {
                    // sell Register
                    sellDao.registerSell(sell);
                    // Order Register
                    if (purchase != null) {
                        Order order = new Order(
                                sell.getNo(),
                                purchase.getNo(),
                                "",
                                ORDER_STATUS.REGISTERED,
                                true
                        );                // 연결 후 위 로직과 동일
                        orderDao.registerOrder(order);
                        message.put("status", true);
                        message.put("result_type", PRODUCT_TRANSACTION_RESULT.ORDER_CREATED);
                        message.put("order_no", order.getNo());
                    } else {
                        message.put("status", true);
                        message.put("result_type", PRODUCT_TRANSACTION_RESULT.SELL_CREATED);
                        message.put("sell_no", sell.getNo());
                    }
                }
            } else {
                message.put("status", false);
                message.put("error_msg", "정보 누락");
                message.put("sent_data", sell);
            }
        } else {
            message.put("status", false);
            message.put("error_msg", "유효하지 않은 상품");
            message.put("sent_data", sell);
        }
        return message;
    }

    /**
     * 구매 입찰 검증
     * 1. 부트페이 영수증 검증
     * 2. 구매 입찰 정보 확인
     * - PURCHASE_TYPE
     * -> 즉시 구매 OR 구매 입찰
     * -> 즉시 구매 시 해당 거래 조건과 맞는 판매 입찰 내역 확인
     * -> 없으면? false
     * -> 있으면 바로 order 생성
     * -> 구매 입찰 시
     * -> 해당 입찰과 조건이 맞는 판매 입찰이 있는지 확인
     * -> 있다면 즉시 구매와 동일하게 로직
     * -> 없다면 등록
     * - pricing
     * -> 가격 정보 모두 확인
     * - price - point + delivery_price + commission = total_price ?
     * -> 포인트 정보 확인 (필요 x -> 결제 단계에서 처리)
     * // 해당 유저가 사용 요청한 포인트 만큼 사용할 수 있는지 검증 -> (필요 x -> 결제 단계에서 처리)
     * - 필수 정보
     * -> delivery_infos, agrees => null check (receipt 는 1번에서 검증)
     * 2. 유저 정보 확인
     * - 기본 유저 관련 예외처리
     * **/
    @Transactional
    public Message registerProductPurchase(Purchase purchase) {
        Message message = new Message();
        if(purchase.getReceipt() != null) {
            if(bootPayService.verifyReceipt(purchase.getReceipt().getReceipt_bootpay())) {
                // 영수증 검증 완료
                boolean pricing_check = purchase.getPrice() - purchase.getPoint() + purchase.getDelivery_price() + purchase.getCommission() == purchase.getTotal_price();
                boolean required_info_check = (
                        purchase.getDelivery_info() != null
                        && purchase.getDelivery_method() != null
                        && purchase.getPurchase_agree() != null
                        && purchase.getP_order_agree() != null
                        && purchase.getPayment_method() != null
                        );
                if(pricing_check && required_info_check) {
                    Sell sell = sellDao.getProductSellForAuction(purchase.getSize_no(), purchase.getPrice());
                    if(purchase.getPurchase_type().equals(PURCHASE_TYPE.DIRECT)) {
                        if(sell != null) {
                            purchase.setExpiration_days(0);
                            purchase.setExpiration_date(LocalDate.now());
                            purchaseDao.registerPurchase(purchase);

                            Order order = new Order(
                                    sell.getNo(),
                                    purchase.getNo(),
                                    "",
                                    ORDER_STATUS.REGISTERED,
                                    true
                            );
                            orderDao.registerOrder(order);
                            message.put("status", true);
                            message.put("result_type", PRODUCT_TRANSACTION_RESULT.ORDER_CREATED);
                            message.put("order_no", order.getNo());
                        } else {
                            message.put("status", false);
                            message.put("error_msg", "잘못된 요청 - 즉시 구매를 위한 판매 입찰 내역이 없음");
                        }
                    } else {
                        purchaseDao.registerPurchase(purchase);
                        if(sell != null) {
                            Order order = new Order(
                                    sell.getNo(),
                                    purchase.getNo(),
                                    "",
                                    ORDER_STATUS.REGISTERED,
                                    true
                            );
                            orderDao.registerOrder(order);
                            message.put("status", true);
                            message.put("result_type", PRODUCT_TRANSACTION_RESULT.ORDER_CREATED);
                            message.put("order_no", order.getNo());
                        } else {
                            message.put("status", true);
                            message.put("result_type", PRODUCT_TRANSACTION_RESULT.PURCHASE_CREATED);
                            message.put("purchase_no", purchase.getNo());
                        }
                    }
                } else {
                    message.put("status", false);
                    message.put("error_msg", "필수 정보 및 가격 데이터 오류");
                }
            } else {
                message.put("status", false);
                message.put("error_msg", "결제 영수증 정보 (receipt) 검증 실패");
            }
        } else {
            message.put("status", false);
            message.put("error_msg", "결제 영수증 정보 (receipt) 누락");
            message.put("sent_data", purchase);
        }
        return message;
    }

    /**
     * TODO Product 관련 공통 예외처리
     * 1. 상품 유무
     * 2. 상품 조회 가능?
     * 3. 로그인 여부
     **/

    public ProductDetail getProductDetail(int product_no) {
        ProductDetail productDetail = new ProductDetail();
        // Product 객체 SET
        productDetail.setProduct(productDao.getProductByNo(product_no));
        // Product 즉시 판매가 SET
        productDetail.setDirect_sell_price(productDao.getProductLowestSellPrice(product_no).getPrice());
        // Product 즉시 구매가 SET
        productDetail.setDirect_purchase_price(productDao.getProductHighestPurchasePrice(product_no).getPrice());
        // Product 주문 체결 내역 SET
        List<ProductPriceWithSize> order_history = productDao.getProductOrderHistory(product_no);
        productDetail.setOrder_history(order_history);
        // 판매 입찰 및 구매 입찰은 사이즈 별 금액 별로 갯수를 가져와야함 O
        productDetail.setSell_history(sellDao.getProductSellHistory(product_no));
        productDetail.setPurchase_history(purchaseDao.getProductPurchaseHistory(product_no));
        // 최근 거래가 SET
        productDetail.setRecent_order_price(order_history.isEmpty() ? null : order_history.get(0).getPrice());
        if (productDetail.getRecent_order_price() != null && order_history.size() > 1) {
            // 최근 거래가가 있고 그 직전의 거래 내역이 있을 때
            productDetail.setRecent_2nd_order_price(order_history.get(1).getPrice());
        }

        // DB 내의 Product Size List
        List<Size> sizes = sizeDao.getProductSize(product_no);
        // ONE SIZE 인지 설정
        productDetail.getProduct().set_one_size(sizes.size() == 1);

        // Product 시세 내역 (전체 사이즈 기준)
        ProductPriceHistories priceHistories = new ProductPriceHistories();
        priceHistories.setHistory_month(productDao.getProductPriceHistory(product_no, DATE_RANGE_TYPE.MONTHLY));
        priceHistories.setHistory_quarter(productDao.getProductPriceHistory(product_no, DATE_RANGE_TYPE.QUARTER));
        priceHistories.setHistory_quarter(productDao.getProductPriceHistory(product_no, DATE_RANGE_TYPE.HALF));
        priceHistories.setHistory_quarter(productDao.getProductPriceHistory(product_no, DATE_RANGE_TYPE.YEARLY));
        priceHistories.setHistory_quarter(productDao.getProductPriceHistory(product_no, DATE_RANGE_TYPE.ALL));
        productDetail.setPrice_history(priceHistories);

        // Product Brand Set
        productDetail.setBrand(brandDao.getBrandByNo(productDetail.getProduct().getBrand_no()));
        // SELL HISTORY O, PURCHASE HISTORY O, SIZE LIST O, WISH COUNT O

        // Product 관심 갯수 SET
        productDetail.setWishes(wishDao.getProductWishCount(product_no));

        // TODO On Purchase => 분리
        // TODO On Sell => 분리
        // TODO Related Styles
        // TODO Related Brand Products

        return productDetail;
    }

    // A and B
    public List<ProductPriceWithSize> getProductSizes(int product_no, boolean is_price, PRODUCT_TRANSACTION_TYPE type) {
        // Prices Per Size Setting
        // 사이즈 조회 시 나오는 가격은 구매 기준 가격이므로 등록된 판매 입찰가 기준으로 가격을 첵정
        List<ProductPriceWithSize> detailSizes = new ArrayList<>();
        // Multi Sizes?
        // TODO IF ONLY ONE SIZE ?
        /**
         * 사이즈 별 (구매) 금액 불러오기 로직
         * 1. 우선 상품에 대한 모든 사이즈 책정
         * 2. 사이즈 별 판매 내역 리스트 확인
         * 3-1. 판매 내역이 없다면 가격 책정 X
         * 3-2. 판매 내역 별로 ORDER 가 연결 되었는지 확인
         *      4-1. ORDER 가 있다면 해당 사항은 PASS (금액으로 안따짐)
         *      4-2. ORDER 가 없다면 해당 사항 데이터 리스트로 참고
         * 5. 사이즈 별로 수행
         * **/
        List<Size> sizes = sizeDao.getProductSize(product_no);
        sizes.forEach(size -> {
            ProductPriceWithSize detailSize = new ProductPriceWithSize();
            detailSize.setNo(size.getNo());
            detailSize.setSize(size.getSize());
            if (is_price) {
                detailSize.setPrice(type.equals(PRODUCT_TRANSACTION_TYPE.PURCHASE) ?
                        sellDao.getSizeProductSellLowestPrice(size.getNo()) :
                        purchaseDao.getSizeProductPurchaseHighestPrice(size.getNo()));
            }
            detailSizes.add(detailSize);
        });
        return detailSizes;
    }

    // C - 미루기
    public List getProductTransactions(int product_no, Integer size_no, PRODUCT_TRANSACTION_TYPE type, Integer page, Integer per_page, String sort_option, String sort_direction) {
        // Page default set
        if (page == null || page < 0) {
            page = 1;
        }
        // per page default set
        if (per_page == null || per_page < 0) {
            per_page = 50;
        }
        // sort_option set
        List<String> default_sort_options = Arrays.asList("size", "price", "reg_date");
        List<String> default_sort_directions = Arrays.asList("desc", "asc");

        if (!default_sort_options.contains(sort_option) && default_sort_directions.contains(sort_direction)) {
            sort_option = type.equals(PRODUCT_TRANSACTION_TYPE.ORDER) ? "reg_date" : "price";
            sort_direction = type.equals(PRODUCT_TRANSACTION_TYPE.ORDER) ? "desc" : "asc";
        }

        if (type.equals(PRODUCT_TRANSACTION_TYPE.ORDER)) {
            List<ProductPriceWithSize> order_list = new ArrayList<>();
            if (size_no != null) {
                // size 기반 검색
//                order_list = orderDao.getOrderTransactions(size_no, type, page, per_page, sort_option, sort_direction);
            } else {
                // product 기반 전체 사이즈 검색

            }
            return order_list;
        } else {
            List<ProductPriceWithSizeAndCount> list = new ArrayList<>();
            return list;
        }
    }

    /**
     * TODO On Detail <br>
     * 1. Detail 내에서 사이즈 분리 <br>
     *  -> 구매 및 판매 클릭 시 가격 불러오는 로직과 동일<br>
     * 2. 관심 상품 등록하기<br>
     * 3. 시세<br>
     *      1) 사이즈 탭 클릭 시 사이즈 종류 불러오기<br>
     *      2) 사이즈 탭 내의 component 클릭 시 시세 전체 종류 불러오기<br>
     *      3) 모든 시세 부분 다 가져오기<br>
     * 4. 체결 거래, 판매 입찰, 구매 입찰<br>
     * -> 기본적으로 첫 리스트 5개는 초반에 불러옴<br>
     * -> 더 보기 클릭 시 전체 항목 및 사이즈 별 데이터 로딩<br>
     * -> 사이즈 불러오는 로직 추가<br>
     * 5. 관련 스타일 최대 8개<br>
     * 6. 동일 브랜드 다른 상품 최대 12개<br>
     * ========================================================<br>
     * TODO REST URL 생성<br>
     * A. 상품에 관한 사이즈 종류 불러오는 URL (O) <br>
     * B. 사이즈 별 금액 책정 불러오는 URL (O) <br>
     * C. 사이즈 별 체결 거래, 판매 입찰, 구매 입찰 불러오는 URL + Reloading () <br>
     **/

    @Transactional
    public void updateProductViews(int product_no) {
        productDao.updateProductViews(product_no);
    }

    public List<ProductMain> getMainProducts(int user_no) {
        // TODO user_no exist?
        List<ProductMain> products = productDao.getMainProducts();
        for (ProductMain product : products) {
            product.setBrand(brandDao.getBrandByProductNo(product.getNo()));
            product.set_wish(wishDao.isUserWishProduct(product.getNo(), user_no));
            product.setPrice(productDao.getProductLowestSellPrice(product.getNo()).getPrice());
        }
        return products;
    }

    public List<ProductShop> getShopProducts(int user_no) {
        // TODO user_no exist?
        List<ProductShop> products = productDao.getShopProducts();
        for (ProductShop product : products) {
            product.setBrand(brandDao.getBrandByProductNo(product.getNo()));
            product.set_wish(wishDao.isUserWishProduct(product.getNo(), user_no));
            product.setPrice(productDao.getProductLowestSellPrice(product.getNo()).getPrice());
            product.setWishes(wishDao.getProductWishCount(product.getNo()));
//            product.setStyles(styleDao.getProductStyleCount(product.getNo()));
//            product.setOrders(orderDao.getProductOrderCount(product.getNo()));
        }
        return products;
    }
}
