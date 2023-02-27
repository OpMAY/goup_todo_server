package com.dao;

import com.mapper.SellStockMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SellStockDao {
    private SellStockMapper mapper;

    private SellStockDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(SellStockMapper.class);
    }
}
