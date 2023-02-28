package com.mapper;

import com.model.kream.product.price.ProductPriceWithSizeAndCount;

import java.util.List;

public interface SellMapper {
    List<ProductPriceWithSizeAndCount> getProductSellHistory(int product_no);
}
