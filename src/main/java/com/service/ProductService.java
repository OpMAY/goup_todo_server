package com.service;

import com.dao.*;
import com.model.kream.DATE_RANGE_TYPE;
import com.model.kream.product.ProductDetail;
import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.model.kream.product.brand.Brand;
import com.model.kream.product.interactions.PRODUCT_TRANSACTION_TYPE;
import com.model.kream.product.price.ProductPriceHistories;
import com.model.kream.product.price.ProductPriceHistory;
import com.model.kream.product.price.ProductPriceWithSize;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.product.size.Size;
import com.response.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {
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
     * TODO Product 관련 공통 예외처리
     * 1. 상품 유무
     * 2. 상품 조회 가능?
     * 3. 로그인 여부
     * **/

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

    // C
    public List getProductTransactions(int product_no, Integer size_no, PRODUCT_TRANSACTION_TYPE type, Integer page, Integer per_page, String sort_option, String sort_direction) {
        // Page default set
        if (page == null || page < 0) {
            page = 1;
        }
        // per page default set
        if(per_page == null || per_page < 0) {
            per_page = 50;
        }
        // sort_option set
        List<String> default_sort_options = Arrays.asList("size", "price", "reg_date");
        List<String> default_sort_directions = Arrays.asList("desc", "asc");

        if(!default_sort_options.contains(sort_option) && default_sort_directions.contains(sort_direction)) {
            sort_option = type.equals(PRODUCT_TRANSACTION_TYPE.ORDER) ? "reg_date" : "price";
            sort_direction = type.equals(PRODUCT_TRANSACTION_TYPE.ORDER) ? "desc" : "asc";
        }

        if(type.equals(PRODUCT_TRANSACTION_TYPE.ORDER)) {
            List<ProductPriceWithSize> order_list = new ArrayList<>();
            if(size_no != null) {
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
