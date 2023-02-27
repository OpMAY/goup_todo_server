package com.dao;

import com.mapper.StyleLikeMapper;
import com.mapper.StyleProductMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleProductDao {

    private StyleProductMapper  styleProductMapper  ;

    private StyleProductDao(SqlSession sqlSession){
        this.styleProductMapper = sqlSession.getMapper(StyleProductMapper.class);
    }


}
