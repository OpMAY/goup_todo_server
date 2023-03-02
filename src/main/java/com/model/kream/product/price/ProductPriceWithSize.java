package com.model.kream.product.price;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductPriceWithSize {
    private int no;
    private String size;
    private Integer price;
    private LocalDate reg_datetime;
}
