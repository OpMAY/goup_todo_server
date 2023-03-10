package com.model.kream.home;

import com.model.common.MFile;
import com.model.common.Time;
import lombok.Data;

@Data
public class Banner  extends Time{
    private int no;
    private MFile banner_image;
    private int banner_flag;
    private String click_to_url;
}
