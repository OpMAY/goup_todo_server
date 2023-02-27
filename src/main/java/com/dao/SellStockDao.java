package com.dao;

import com.mapper.CategoryMapper;
import com.mapper.SellStockMapper;
import org.apache.ibatis.session.SqlSession;

public class SellStockDao {
    private SellStockMapper sellStockMapper;

    private SellStockDao(SqlSession sqlSession){
        this.sellStockMapper = sqlSession.getMapper(SellStockMapper.class);
    }
}
