package com.service;

import com.dao.BannerDao;
import com.model.common.MFile;
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

    private final BannerDao bannerDao;

    public List<Banner> getAllBanner() {
        return bannerDao.getAllBanner();
    }

    @Transactional
    public void registBanner(Banner banner) {
        bannerDao.registBanner(banner);
    }

    @Transactional
    public void editBanner(Banner banner) {
        bannerDao.editBanner(banner);
    }

    @Transactional
    public void deleteBanner(int no) {
        bannerDao.deleteBanner(no);
    }

    public Banner getBanner(int no) {
        return bannerDao.getBanner(no);
    }

    public List<Banner> getActiveBanners() {
        return bannerDao.getActiveBanners();
    }
}
