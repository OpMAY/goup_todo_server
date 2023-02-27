package com.model.kream.style.interaction;

import com.model.common.Time;
import lombok.Data;

@Data
public class StyleFollow extends Time {
    private int follow_user_no;
    private int followed_user_no;
}
