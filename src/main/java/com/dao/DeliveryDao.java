package com.dao;

import com.mapper.DeliveryMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DeliveryDao {
    private DeliveryMapper mapper;

    private DeliveryDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(DeliveryMapper.class);
    }
}
