package com.dao;

import com.mapper.CategoryMapper;
import com.model.kream.product.category.Category;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryDao {
    private CategoryMapper mapper;

    private CategoryDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(CategoryMapper.class);
    }

    public Category getCategoryByNo(int no) {
        return mapper.getCategoryByNo(no);
    }
}
