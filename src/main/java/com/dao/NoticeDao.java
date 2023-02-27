package com.dao;

import com.mapper.NoticeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {

    private NoticeMapper mapper;

    private NoticeDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(NoticeMapper.class);
    }
}

