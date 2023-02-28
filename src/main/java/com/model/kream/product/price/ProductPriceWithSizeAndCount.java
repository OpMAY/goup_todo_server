package com.model.kream.product.price;

import lombok.Data;

@Data
public class ProductPriceWithSizeAndCount {
    private String size;
    private int price;
    private int count;
}
