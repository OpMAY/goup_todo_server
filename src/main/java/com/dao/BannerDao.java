package com.dao;

import com.mapper.BannerMapper;
import com.mapper.NoticeMapper;
import com.model.kream.home.Banner;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerDao {

    private BannerMapper mapper;

    private BannerDao(SqlSession sqlSession){

        this.mapper = sqlSession.getMapper(BannerMapper.class);
    }

    public List<Banner> getBanner(){
        return mapper.getBanner();
    }

}
