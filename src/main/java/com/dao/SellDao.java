package com.dao;

import com.mapper.SellMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SellDao {
    private SellMapper mapper;

    private SellDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(SellMapper.class);
    }
}
