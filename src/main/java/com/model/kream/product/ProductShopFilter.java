package com.model.kream.product;

import com.model.kream.product.brand.Brand;
import com.model.kream.product.category.Category;
import com.model.kream.product.category.CategoryFilter;
import lombok.Data;

import java.util.List;

@Data
public class ProductShopFilter {
    private List<Brand> brands;
    private List<CategoryFilter> categories;
}
