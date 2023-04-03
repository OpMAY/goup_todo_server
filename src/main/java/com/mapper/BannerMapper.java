package com.mapper;

import com.model.kream.home.Banner;

import java.util.List;
import java.util.Map;

public interface BannerMapper {

    List<Banner> getAllBanner();

    Banner getBanner(int no);

    void registBanner(Banner banner);

    void editBanner(Map<String,Object> banner);

    void deleteBanner(int no);


}
