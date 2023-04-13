package com.mapper;

import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Purchase;
import com.model.kream.order.before.sub.purchase.PURCHASE_TYPE;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.shop.PurchaseList;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseMapper {
    List<ProductPriceWithSizeAndCount> getProductPurchaseHistory(int product_no);

    Integer getSizeProductPurchaseHighestPrice(int size_no);

    Purchase getPurchaseForOrder(@Param("size_no") int size_no,
                                 @Param("price") int price);

    void registerPurchase(Purchase purchase);

    List<PurchaseList> getMyPurchase(@Param("user_no") int user_no,
                                 @Param("expiration_date")
                                 LocalDate expiration_date,
                                 @Param("after") boolean after);


    List<PurchaseList> getMyPurchaseByOrder(@Param("user_no") int user_no,
                                            @Param("status") DELIVERY_STATUS status,
                                            @Param("type") SELLSTOCK_TYPE type);


    List<PurchaseList> getCompletePurchase(@Param("user_no") int user_no, @Param("status") DELIVERY_STATUS status);
}
