package com.mapper;

import com.model.kream.point.Point;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PointMapper {

    List<Point> getPoint( int user_no);

    void addPoint(Point point);


    void editPoint(@Param("user_no") int user_no, @Param("point") int point);

    Point getPointData(int no);
}
