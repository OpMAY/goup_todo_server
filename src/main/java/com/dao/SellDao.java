package com.dao;

import com.mapper.SellMapper;
import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Sell;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.shop.SellList;
import org.apache.ibatis.session.SqlSession;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class SellDao {
    private SellMapper mapper;

    private SellDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(SellMapper.class);
    }

    public List<ProductPriceWithSizeAndCount> getProductSellHistory(int product_no) {
        return mapper.getProductSellHistory(product_no);
    }

    public Integer getSizeProductSellLowestPrice(int size_no) {
        return mapper.getSizeProductSellLowestPrice(size_no);
    }

    public void registerSell(Sell sell) {
        mapper.registerSell(sell);
    }

    public Sell getProductSellForAuction(int size_no, int price) {
        return mapper.getProductSellForAuction(size_no, price);
    }

    public List<Sell> getMySell(int user_no,LocalDate expiration_date,boolean after ) {
        return mapper.getMySell(user_no ,expiration_date,after);
    }

    public List<SellList> getMySellByOrder(int user_no, SELLSTOCK_TYPE type , DELIVERY_STATUS status) {
        return mapper.getMySellByOrder(user_no,type,status);
    }

    public List<Sell> getCompleteSell(int user_no, ORDER_STATUS order_status) {
        return mapper.getCompleteSell(user_no,order_status);
    }

    public List<Sell> getMySellEnd(int user_no, LocalDate expiration_date) {
        return mapper.getMySellEnd(user_no,expiration_date);
    }
}
