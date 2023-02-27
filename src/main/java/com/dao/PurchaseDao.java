package com.dao;

import com.mapper.PurchaseMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PurchaseDao {
    private PurchaseMapper mapper;

    private PurchaseDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(PurchaseMapper.class);
    }
}
