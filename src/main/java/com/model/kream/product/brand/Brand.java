package com.model.kream.product.brand;

import com.model.common.Time;
import lombok.Data;

@Data
public class Brand extends Time {
    private int no;
    private String name;
    private String color;
}
