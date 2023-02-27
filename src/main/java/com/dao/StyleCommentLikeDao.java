package com.dao;

import com.mapper.StyleCommentLikeMapper;
import com.mapper.StyleCommentMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleCommentLikeDao {
    private StyleCommentLikeMapper  styleCommentLikeMapper ;
    private StyleCommentLikeDao(SqlSession sqlSession){
        this.styleCommentLikeMapper = sqlSession.getMapper(StyleCommentLikeMapper.class);
    }
}
