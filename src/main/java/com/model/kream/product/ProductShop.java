package com.model.kream.product;

import com.model.common.MFile;
import com.model.kream.product.brand.Brand;
import lombok.Data;

/**
 * Shop 화면에서 보여지는 Product Model
 * **/
@Data
public class ProductShop {
    private int no;
    private String en_name;
    private String kor_name;
    private Integer price;
    private int category_no;
    private boolean is_wish;
    private int wishes;
    private int styles;
    private int orders;
    private Brand brand;
    private MFile image;
}
