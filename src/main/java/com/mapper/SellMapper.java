package com.mapper;

import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Sell;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.shop.SellList;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SellMapper {
    List<ProductPriceWithSizeAndCount> getProductSellHistory(int product_no);

    Integer getSizeProductSellLowestPrice(int size_no);

    void registerSell(Sell sell);

    Sell getProductSellForAuction(int size_no, int price);

    List<Sell> getMySell( @Param("user_no") int user_no , @Param("expiration_date") LocalDate expiration_date
                            ,@Param("after") boolean after);
    List<Sell> getMySellEnd(@Param("user_no") int user_no,@Param("expiration_date") LocalDate expiration_date);
    List<SellList> getMySellByOrder(@Param("user_no") int user_no,
                                    @Param("type") SELLSTOCK_TYPE type,
                                    @Param("status")DELIVERY_STATUS status

                                );

    List<Sell> getCompleteSell(@Param("user_no") int user_no, @Param("order_status")ORDER_STATUS order_status);


}
