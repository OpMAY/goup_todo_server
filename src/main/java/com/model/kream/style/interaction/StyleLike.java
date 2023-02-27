package com.model.kream.style.interaction;

import com.model.common.Time;
import lombok.Data;

@Data
public class StyleLike extends Time {
    private int style_no;
    private int style_user_no;
}
