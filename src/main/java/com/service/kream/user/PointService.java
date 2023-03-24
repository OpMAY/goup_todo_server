package com.service.kream.user;

import com.dao.PointDao;
import com.model.kream.point.Point;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PointService {
    private final PointDao pointDao;

    public List<Point> getPoint(int user_no ) {
        return pointDao.getPoint(user_no);
    }

    public Point getPointData(int no){
        return pointDao.getPointData(no);
    }

    @Transactional
    public void registPoint(Point point) {
        pointDao.registPoint(point);
    }

    @Transactional
    public void editPoint(int user_no,int point) {

        pointDao.editPoint(user_no,point);
    }
}
