package com.mapper;

import com.model.kream.order.before.Purchase;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PurchaseMapper {
    List<ProductPriceWithSizeAndCount> getProductPurchaseHistory(int product_no);

    Integer getSizeProductPurchaseHighestPrice(int size_no);

    Purchase getPurchaseForOrder(@Param("size_no") int size_no, @Param("price") int price);

    void registerPurchase(Purchase purchase);
}
