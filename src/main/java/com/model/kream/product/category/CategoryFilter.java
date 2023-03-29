package com.model.kream.product.category;

import lombok.Data;

@Data
public class CategoryFilter {
    private int no;
    private String name;
    private int parent_no;
    private String parent_name;
}
