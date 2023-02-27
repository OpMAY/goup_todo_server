package com.dao;

import com.mapper.OrderMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.test.context.jdbc.Sql;

public class OrderDao {
    private OrderMapper orderMapper;

    private OrderDao(SqlSession sqlSession){
        this.orderMapper = sqlSession.getMapper(OrderMapper.class);
    }
}
