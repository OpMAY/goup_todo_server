package com.dao;

import com.mapper.StyleUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleUserDao {

    private StyleUserMapper mapper;

    private StyleUserDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(StyleUserMapper.class);
    }


}
