package com.model.kream.product.brand;

import com.model.common.MFile;
import lombok.Data;

@Data
public class BrandMain {
    private int no;
    private String name;
    private String color;
    private MFile image;
}
