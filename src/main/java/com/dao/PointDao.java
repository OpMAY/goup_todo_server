package com.dao;

import com.mapper.PointMapper;
import com.model.kream.point.Point;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class PointDao {
    private PointMapper mapper;

    private PointDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(PointMapper.class);
    }

    private void addPoint(Point point) {
        mapper.addPoint(point);
    }
}
