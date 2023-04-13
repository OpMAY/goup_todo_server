package com.model.kream.order.after;

import com.model.common.MFile;
import com.model.common.Time;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import lombok.Data;

import java.util.List;

@Data
public class Inspection extends Time {
    private int no;
    private int order_no;
    private String content;
    private List<MFile> images;
    private int status;
    private INSPECTION_TYPE type;
}
