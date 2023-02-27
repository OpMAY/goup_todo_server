package com.dao;

import com.mapper.QnAMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDao {
    private QnAMapper mapper;

    private QnaDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(QnAMapper.class);
    }
}
