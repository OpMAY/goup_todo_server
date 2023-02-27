package com.dao;

import com.mapper.StyleFollowMapper;
import com.mapper.StyleLikeMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleLikeDao {

    private StyleLikeMapper styleLikeMapper ;

    private StyleLikeDao(SqlSession sqlSession){
        this.styleLikeMapper = sqlSession.getMapper(StyleLikeMapper.class);
    }


}
