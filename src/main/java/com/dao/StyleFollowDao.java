package com.dao;

import com.mapper.StyleFollowMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleFollowDao {

    private StyleFollowMapper mapper;

    private StyleFollowDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(StyleFollowMapper.class);
    }


}
