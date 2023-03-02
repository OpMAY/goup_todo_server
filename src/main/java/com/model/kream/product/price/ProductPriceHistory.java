package com.model.kream.product.price;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductPriceHistory {
    private int price;
    private LocalDate target_date;
}
