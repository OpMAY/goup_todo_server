package com.mapper;

import com.model.kream.product.category.Category;
import com.model.kream.product.category.CategoryFilter;

import java.util.List;

public interface CategoryMapper {

    Category getCategoryByNo(int no);

    List<CategoryFilter> getCategoryFilters();
}
