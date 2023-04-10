package com.model.kream.product.category;

import lombok.Data;

import java.util.List;

@Data
public class CategoryAdmin {
    private int no;
    private String name;
    private List<Category> items;
    private int products;
}
