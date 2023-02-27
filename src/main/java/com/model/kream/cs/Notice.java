package com.model.kream.cs;

import com.model.common.Time;
import lombok.Data;

@Data
public class Notice extends Time {
    private int no;
    private String title;
    private String content;
    private boolean flag;
}
