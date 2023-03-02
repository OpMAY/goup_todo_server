package com.dao;

import com.mapper.OrderMapper;
import com.model.kream.order.Order;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class OrderDao {
    private OrderMapper mapper;

    private OrderDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(OrderMapper.class);
    }

    public void registerOrder(Order order) {
        mapper.registerOrder(order);
    }
}
