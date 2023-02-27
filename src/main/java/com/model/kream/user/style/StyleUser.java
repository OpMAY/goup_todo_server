package com.model.kream.user.style;

import com.model.common.Time;
import lombok.Data;

@Data
public class StyleUser extends Time {
    private int no;
    private int user_no;
    private String profile_name;
    private String name;
    private String introduce;
}
