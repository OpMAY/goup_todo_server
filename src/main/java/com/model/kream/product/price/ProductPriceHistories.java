package com.model.kream.product.price;

import lombok.Data;

import java.util.List;

@Data
public class ProductPriceHistories {
    private List<ProductPriceHistory> history_month;
    private List<ProductPriceHistory> history_quarter;
    private List<ProductPriceHistory> history_half;
    private List<ProductPriceHistory> history_year;
    private List<ProductPriceHistory> history_all;
}
