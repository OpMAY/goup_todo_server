package com.dao;

import com.mapper.StyleProductMapper;
import com.mapper.StyleUserMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleUserDao {

    private StyleUserMapper styleUserMapper   ;

    private StyleUserDao(SqlSession sqlSession){
        this.styleUserMapper = sqlSession.getMapper(StyleUserMapper.class);
    }


}
