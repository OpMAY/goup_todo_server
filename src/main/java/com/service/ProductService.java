package com.service;

import com.dao.*;
import com.model.kream.DATE_RANGE_TYPE;
import com.model.kream.product.ProductDetail;
import com.model.kream.product.price.ProductPriceWithSize;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public ProductDetail getProductDetail(int product_no) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(productDao.getProductByNo(product_no));
        productDetail.setDirect_sell_price(productDao.getProductLowestSellPrice(product_no).getPrice());
        productDetail.setDirect_purchase_price(productDao.getProductHighestPurchasePrice(product_no).getPrice());
        List<ProductPriceWithSize> order_history = productDao.getProductOrderHistory(product_no);
        productDetail.setOrder_history(order_history);
        productDetail.setRecent_order_price(order_history.isEmpty() ? null : order_history.get(0).getPrice());
        if(productDetail.getRecent_order_price() != null && order_history.size() > 1) {
            // 최근 거래가가 있고 그 직전의 거래 내역이 있을 때
            productDetail.setRecent_2nd_order_price(order_history.get(1).getPrice());
        }
        productDetail.setPrice_history(productDao.getProductPriceHistory(product_no, DATE_RANGE_TYPE.ALL));
        productDetail.setOrder_history_date_range_type(DATE_RANGE_TYPE.ALL);
        productDetail.setBrand(brandDao.getBrandByNo(productDetail.getProduct().getBrand_no()));
        // SELL HISTORY O, PURCHASE HISTORY O, SIZE LIST O, WISH COUNT O
        productDetail.setSell_history(sellDao.getProductSellHistory(product_no));
        productDetail.setPurchase_history(purchaseDao.getProductPurchaseHistory(product_no));
        productDetail.setSizes(sizeDao.getProductSize(product_no));
        productDetail.setWishes(wishDao.getProductWishCount(product_no));
        // 판매 입찰 및 구매 입찰은 사이즈 별 금액 별로 갯수를 가져와야함 O
        return productDetail;
    }

    @Transactional
    public void updateProductViews(int product_no) {
        productDao.updateProductViews(product_no);
    }
}
