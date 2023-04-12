package com.mapper;

import com.model.common.MFile;
import com.model.kream.home.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BannerMapper {

    List<Banner> getAllBanner();

    Banner getBanner(int no);

    void registBanner(Banner banner);

    void editBanner(Banner banner);

    void deleteBanner(int no);

    List<Banner> getActiveBanners();


}
