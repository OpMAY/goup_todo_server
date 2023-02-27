package com.dao;

import com.mapper.DeliveryMapper;
import org.apache.ibatis.session.SqlSession;

public class DeliveryDao {
    private DeliveryMapper deliveryMapper;

    private DeliveryDao(SqlSession sqlSession){
        this.deliveryMapper = sqlSession.getMapper(DeliveryMapper.class);
    }
}
