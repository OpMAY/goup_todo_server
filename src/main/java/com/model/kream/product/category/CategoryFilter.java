package com.model.kream.product.category;

import lombok.Data;

import java.util.List;

@Data
public class CategoryFilter {
    private int no;
    private String name;
    private List<Category> items;
}
