package com.mapper;

import com.model.kream.order.before.Sell;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SellMapper {
    List<ProductPriceWithSizeAndCount> getProductSellHistory(int product_no);

    Integer getSizeProductSellLowestPrice(int size_no);

    void registerSell(Sell sell);

    Sell getProductSellForAuction(@Param("size_no") int size_no, @Param("price") int price);
}
