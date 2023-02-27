package com.dao;

import com.mapper.BrandMapper;
import org.apache.ibatis.session.SqlSession;

public class BrandDao {
    private BrandMapper brandMapper;

    private BrandDao(SqlSession sqlSession){
        this.brandMapper = sqlSession.getMapper(BrandMapper.class);
    }
}
