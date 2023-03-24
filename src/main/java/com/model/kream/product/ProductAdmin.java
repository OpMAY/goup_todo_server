package com.model.kream.product;

import com.model.kream.product.brand.Brand;
import com.model.kream.product.category.Category;
import lombok.Data;

@Data
public class ProductAdmin {
    private Product product;
    private Brand brand;
    private Category category;
    private Category upperCategory;
    private Integer price;
    private int wishes;
}
