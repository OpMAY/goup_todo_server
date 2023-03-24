package com.dao;

import com.mapper.PointMapper;
import com.model.kream.point.Point;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PointDao {
    private PointMapper mapper;

    private PointDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(PointMapper.class);
    }

    private void addPoint(Point point) {
        mapper.addPoint(point);
    }

    public List<Point> getPoint(int user_no) {
        return mapper.getPoint(user_no);
    }

    public Point getPointData(int no){
        return mapper.getPointData(no);
    }


   public void registPoint(Point point) {
        mapper.addPoint(point);
    }

    public void editPoint(int user_no, int point) {

        mapper.editPoint(user_no,point);
    }
}
