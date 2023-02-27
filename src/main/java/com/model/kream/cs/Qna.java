package com.model.kream.cs;

import com.model.common.Time;
import lombok.Data;

@Data
public class Qna extends Time {
    private int no;
    private String title;
    private String content;
    private QNA_TYPE type;
    private boolean flag;
}
