package com.mapper;

import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Sell;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
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
    List<Sell> getMySellByOrder(@Param("user_no") int user_no,
                                @Param("status") SELLSTOCK_TYPE status ,
                                @Param("type")INSPECTION_TYPE type,
                                @Param("order_status")ORDER_STATUS order_status
                             );

    List<Sell> getMySellNotByOrder(@Param("user_no") int user_no, @Param("sell_type")SELL_TYPE sell_type);


}
