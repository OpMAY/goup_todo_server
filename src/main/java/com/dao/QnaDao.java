package com.dao;

import com.mapper.BrandMapper;
import com.mapper.QnAMapper;
import org.apache.ibatis.session.SqlSession;

public class QnaDao {
    private QnAMapper qnAMapper;

    private QnaDao(SqlSession sqlSession){
        this.qnAMapper = sqlSession.getMapper(QnAMapper.class);
    }
}
