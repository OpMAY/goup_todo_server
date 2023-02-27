package com.model.kream.user.delete;

import com.model.common.Time;
import com.model.kream.user.LOGIN_TYPE;
import lombok.Data;

@Data
public class DeletedUser extends Time {
    private int user_no;
    private String access_token;
    private LOGIN_TYPE login_type;
}
