package com.dao;

import com.mapper.StyleCommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleCommentDao {
    private StyleCommentMapper mapper;
    private StyleCommentDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(StyleCommentMapper.class);
    }
}
