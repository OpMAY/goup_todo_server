package com.dao;

import com.mapper.BrandMapper;
import com.mapper.PointMapper;
import org.apache.ibatis.session.SqlSession;

public class PointDao {
    private PointMapper  pointMapper;

    private PointDao(SqlSession sqlSession){
        this.pointMapper = sqlSession.getMapper(PointMapper.class);
    }
}
