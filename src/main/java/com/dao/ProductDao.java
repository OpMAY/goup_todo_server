package com.dao;

import com.mapper.ProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    private ProductMapper mapper;

    private ProductDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(ProductMapper.class);
    }
}
