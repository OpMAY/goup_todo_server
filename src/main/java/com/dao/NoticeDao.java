package com.dao;

import com.mapper.NoticeMapper;
import org.apache.ibatis.session.SqlSession;

public class NoticeDao {

    private NoticeMapper noticeMapper;

    private NoticeDao(SqlSession sqlSession){
        this.noticeMapper = sqlSession.getMapper(NoticeMapper.class);
    }
}

