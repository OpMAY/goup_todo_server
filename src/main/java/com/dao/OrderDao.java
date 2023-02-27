package com.dao;

import com.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    private OrderMapper mapper;

    private OrderDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(OrderMapper.class);
    }
}
