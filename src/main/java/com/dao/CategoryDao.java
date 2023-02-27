package com.dao;

import com.mapper.CategoryMapper;
import com.mapper.StyleMapper;
import org.apache.ibatis.session.SqlSession;

public class CategoryDao {
    private CategoryMapper categoryMapper;

    private CategoryDao(SqlSession sqlSession){
        this.categoryMapper = sqlSession.getMapper(CategoryMapper.class);
    }
}
