package com.mapper;

import com.model.kream.point.Point;

import java.util.List;

public interface PointMapper {

    List<Point> getPoint(int no);

    void addPoint(Point point);


}
