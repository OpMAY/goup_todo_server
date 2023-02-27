package com.dao;

import com.mapper.SellStockMapper;
import com.mapper.StyleCommentMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleCommentDao {
    private StyleCommentMapper styleCommentMapper;
    private StyleCommentDao(SqlSession sqlSession){
        this.styleCommentMapper = sqlSession.getMapper(StyleCommentMapper.class);
    }
}
