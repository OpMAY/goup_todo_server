package com.model.kream.point;

import com.model.common.Time;
import lombok.Data;

@Data
public class Point extends Time {
    private int no;
    private int user_no;
    private int point;
    private POINT_TYPE type;
    private int used_point;
    private boolean flag;
}
