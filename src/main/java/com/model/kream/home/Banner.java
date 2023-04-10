package com.model.kream.home;

import com.model.common.MFile;
import com.model.common.Time;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Banner extends Time {
    private int no;
    private MFile banner_image;
    private boolean banner_flag;
    private String click_to_url;
    private String bg_color;

    private MultipartFile file;
}
