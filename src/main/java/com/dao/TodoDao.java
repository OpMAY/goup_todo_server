package com.dao;

import com.mapper.TodoMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class TodoDao {
    private final TodoMapper mapper;

    private TodoDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(TodoMapper.class);
    }
}
