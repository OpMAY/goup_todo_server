package com.mapper;

import com.model.kream.product.price.ProductPriceWithSizeAndCount;

import java.util.List;

public interface PurchaseMapper {
    List<ProductPriceWithSizeAndCount> getProductPurchaseHistory(int product_no);

    Integer getSizeProductPurchaseHighestPrice(int size_no);
}
