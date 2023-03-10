package com.service;

import com.dao.BannerDao;
import com.model.kream.home.Banner;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BannerService {

    private  final BannerDao bannerDao;

    public List<Banner> getBanner(){
        return bannerDao.getBanner();
    }
}
