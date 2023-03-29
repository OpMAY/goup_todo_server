package com.model.kream.product;

import com.model.common.MFile;
import com.model.common.Time;
import lombok.Data;

import java.util.List;

@Data
public class Product extends Time {
    private int no;
    private int category_no;
    private int brand_no;
    private ProductInfo product_info;
    private String en_name;
    private String kor_name;
    private int gender;
    private int views;
    // BOOLEANS
    private boolean is_one_size;
    private boolean is_direct;
    private boolean product_yn;
    // MIGHT BE NO USE
    private int price;

    // IMAGES
    private List<MFile> images;
}
