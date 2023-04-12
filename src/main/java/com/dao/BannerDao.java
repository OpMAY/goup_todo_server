package com.dao;

import com.exception.ContentsException;
import com.mapper.BannerMapper;
import com.mapper.NoticeMapper;
import com.model.common.MFile;
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

    public Banner getBanner(int no) {
        return mapper.getBanner(no);
    }

    public void registBanner(Banner banner){
        mapper.registBanner(banner);
    }


    public void editBanner(Banner banner) {
        mapper.editBanner(banner);
    }


    public void deleteBanner(int no) {
        mapper.deleteBanner(no);
    }

    public List<Banner> getActiveBanners() {
        return mapper.getActiveBanners();
    }

}
