package com.dao;

import com.exception.ContentsException;
import com.mapper.BannerMapper;
import com.mapper.NoticeMapper;
import com.model.kream.home.Banner;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BannerDao {

    private BannerMapper mapper;

    private BannerDao(SqlSession sqlSession){

        this.mapper = sqlSession.getMapper(BannerMapper.class);
    }

    public List<Banner> getAllBanner(){
        return mapper.getAllBanner();
    }

    public void registBanner(Banner banner){
        mapper.registBanner(banner);
    }


    public void editBanner(Map<String, Object> map) {
        if(map != null || map.size()>0){
            mapper.editBanner(map);
        }

    }

    public void deleteBanner(int no) {
        mapper.deleteBanner(no);
    }
}
