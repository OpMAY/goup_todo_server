package com.model.kream.style;

import com.model.common.Time;
import lombok.Data;

@Data
public class StyleComment extends Time {
    private int no;
    private int style_user_no;
    // 자기 참조
    private int style_comment_no;
    private String content;
}
