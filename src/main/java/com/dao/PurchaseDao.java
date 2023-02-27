package com.dao;

import com.mapper.BrandMapper;
import com.mapper.PurchaseMapper;
import org.apache.ibatis.session.SqlSession;

public class PurchaseDao {
    private PurchaseMapper  purchaseMapper;

    private PurchaseDao(SqlSession sqlSession){
        this.purchaseMapper = sqlSession.getMapper(PurchaseMapper.class);
    }
}
