package com.mapper;

import com.model.kream.product.category.Category;
import com.model.kream.product.category.CategoryAdmin;
import com.model.kream.product.category.CategoryFilter;

import java.util.List;

public interface CategoryMapper {

    Category getCategoryByNo(int no);

    List<Category> getParentCategories();

    List<Category> getChildrenCategories(int parent_no);

    List<CategoryAdmin> getCategoryChildrenAdmin(int parent_no);
}
