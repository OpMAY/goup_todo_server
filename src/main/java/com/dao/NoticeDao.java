package com.dao;

import com.mapper.NoticeMapper;
import com.model.kream.cs.Notice;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoticeDao {

    private NoticeMapper mapper;

    private NoticeDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(NoticeMapper.class);
    }

    public Notice getNotice(int no){
       return mapper.getNotice(no);
    }

    public List<Notice> getNotices(int page) {
        int offset = (page - 1) * 20;
        return mapper.getNotices(offset);
    }

    public int getNoticePages() {
        return mapper.getNoticePages();
    }
}

