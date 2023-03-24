package com.mapper;

import com.model.kream.point.Point;

import java.util.List;

public interface PointMapper {

    List<Point> getPoint( int user_no);

    void addPoint(Point point);


    void editPoint(int user_no, int point);

    Point getPointData(int no);
}
