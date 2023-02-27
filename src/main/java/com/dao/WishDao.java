package com.dao;


import com.mapper.WishMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class WishDao {
    private WishMapper mapper;

    private WishDao(SqlSession sqlSession){
        this.mapper =sqlSession.getMapper(WishMapper.class);
    }


}
