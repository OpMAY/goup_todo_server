package com.service;

import com.dao.BannerDao;
import com.model.kream.home.Banner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BannerService {

    private  final BannerDao bannerDao;

    public List<Banner> getAllBanner(){
        return bannerDao.getAllBanner();
    }

    @Transactional
    public void registBanner(Banner banner){
        bannerDao.registBanner(banner);
    }

    @Transactional
    public void editBanner(Map<String, Object> data , Banner banner) {
            data.put("no",banner.getNo());
            data.put("banner_image",banner.getBanner_image());
            data.put("banner_flag",banner.getBanner_flag());
            data.put("click_to_url",banner.getClick_to_url());
            data.put("reg_datetime",banner.getReg_datetime());
            data.put("update_datetime",banner.getUpdated_datetime());

            bannerDao.editBanner(data);


    }

    @Transactional
    public void deleteBanner(int no) {
        bannerDao.deleteBanner(no);
    }

    public Banner getBanner(int no) {
        return bannerDao.getBanner(no);
    }
}
