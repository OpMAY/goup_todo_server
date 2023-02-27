package com.dao;

import com.mapper.InspectionMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class InspectionDao {

    private InspectionMapper mapper;

    private InspectionDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(InspectionMapper.class);
    }
}
