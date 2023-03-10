package com.dao;

import com.mapper.SellMapper;
import com.model.kream.order.before.Sell;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

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
}
