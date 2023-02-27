package com.dao;

import com.mapper.StyleProductMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleProductDao {

    private StyleProductMapper mapper;

    private StyleProductDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(StyleProductMapper.class);
    }


}
