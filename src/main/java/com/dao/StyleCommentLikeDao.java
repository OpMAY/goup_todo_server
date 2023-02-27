package com.dao;

import com.mapper.StyleCommentLikeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleCommentLikeDao {
    private StyleCommentLikeMapper mapper;
    private StyleCommentLikeDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(StyleCommentLikeMapper.class);
    }
}
