package com.dao;

import com.mapper.StyleLikeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleLikeDao {

    private StyleLikeMapper mapper;

    private StyleLikeDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(StyleLikeMapper.class);
    }


}
