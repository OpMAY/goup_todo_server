package com.model.kream.product;

import com.model.kream.product.brand.Brand;
import com.model.kream.product.category.Category;
import com.model.kream.product.size.Size;
import lombok.Data;

import java.util.List;

@Data
public class ProductAdmin {
    private Product product;
    private Brand brand;
    private Category category;
    private Category upperCategory;
    private Integer price;
    private int wishes;
    private int orders;
    private int sells;
    private int purchases;
    private List<Size> sizes;
}
