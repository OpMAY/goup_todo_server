package com.dao;

import com.mapper.PointMapper;
import com.mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;

public class ProductDao {
    private ProductMapper productMapper;

    private ProductDao(SqlSession sqlSession){
        this.productMapper = sqlSession.getMapper(ProductMapper.class);
    }
}
