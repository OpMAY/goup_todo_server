package com.dao;

import com.mapper.BannerMapper;
import com.mapper.NoticeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class BannerDao {

    private BannerMapper mapper;

    private BannerDao(SqlSession sqlSession){

        this.mapper = sqlSession.getMapper(BannerMapper.class);
    }

}
