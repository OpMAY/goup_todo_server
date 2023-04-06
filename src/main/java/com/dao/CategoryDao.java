package com.dao;

import com.mapper.CategoryMapper;
import com.model.kream.product.category.Category;
import com.model.kream.product.category.CategoryAdmin;
import com.model.kream.product.category.CategoryFilter;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {
    private CategoryMapper mapper;

    private CategoryDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(CategoryMapper.class);
    }

    public Category getCategoryByNo(int no) {
        return mapper.getCategoryByNo(no);
    }

    public List<Category> getParentCategories() {
        return mapper.getParentCategories();
    }

    public List<Category> getChildrenCategories(int parent_no) {
        return mapper.getChildrenCategories(parent_no);
    }

    public List<CategoryAdmin> getCategoryChildrenAdmin(int parent_no) {
        return mapper.getCategoryChildrenAdmin(parent_no);
    }
}
