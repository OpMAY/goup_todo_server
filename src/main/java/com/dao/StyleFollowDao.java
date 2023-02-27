package com.dao;

import com.mapper.AccountInfoMapper;
import com.mapper.StyleFollowMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleFollowDao {

    private StyleFollowMapper styleFollowMapper;

    private StyleFollowDao(SqlSession sqlSession){
        this.styleFollowMapper = sqlSession.getMapper(StyleFollowMapper.class);
    }


}
