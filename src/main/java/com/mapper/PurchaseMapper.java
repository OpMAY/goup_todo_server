package com.mapper;

import com.model.kream.order.before.Purchase;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;

import java.util.List;

public interface PurchaseMapper {
    List<ProductPriceWithSizeAndCount> getProductPurchaseHistory(int product_no);

    Integer getSizeProductPurchaseHighestPrice(int size_no);

    Purchase getPurchaseForOrder(int size_no, int price);

    void registerPurchase(Purchase purchase);
}
