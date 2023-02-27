package com.model.kream.product;

import com.model.common.Time;
import lombok.Data;

@Data
public class Product extends Time {
    private int no;
    private int category_no;
    private int brand_no;
    private ProductInfo productInfo;
    private String en_name;
    private String kor_name;
    private int gender;
    // BOOLEANS
    private boolean is_one_size;
    private boolean is_fast_delivery;
    private boolean is_direct;
    private boolean product_yn;
    // MIGHT BE NO USE
    private int price;
}
