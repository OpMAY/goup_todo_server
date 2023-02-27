package com.model.kream.product;

import lombok.Data;

@Data
public class ProductInfo {
    private String released_date;
    private Integer released_price;
    private String model_code;
    private String color;
}
