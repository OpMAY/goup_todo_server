package com.dao;

import com.mapper.PurchaseMapper;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseDao {
    private PurchaseMapper mapper;

    private PurchaseDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(PurchaseMapper.class);
    }

    public List<ProductPriceWithSizeAndCount> getProductPurchaseHistory(int product_no) {
        return mapper.getProductPurchaseHistory(product_no);
    }
}
