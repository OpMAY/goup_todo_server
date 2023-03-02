package com.model.kream.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.model.common.MFile;
import com.model.kream.product.brand.Brand;
import lombok.Data;

/**
 * Main 화면에서 보여지는 Product Model
 **/
@Data
public class ProductMain {
    private int no;
    private String name;
    private MFile image;
    private boolean is_wish;
    private Integer price;
    private Brand brand;
}
