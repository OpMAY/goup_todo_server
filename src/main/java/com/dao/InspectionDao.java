package com.dao;

import com.mapper.InspectionMapper;
import org.apache.ibatis.session.SqlSession;

public class InspectionDao {

    private InspectionMapper inspectionMapper;

    private InspectionDao(SqlSession sqlSession){
        this.inspectionMapper = sqlSession.getMapper(InspectionMapper.class);
    }
}
