package com.model.kream.product.price;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductPriceHistory {
    private int price;
    private String target_date;
}
