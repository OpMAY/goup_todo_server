package com.model.kream.user.account;

import com.model.common.Time;
import lombok.Data;

@Data
public class AccountInfo extends Time {
    private int user_no;
    private String bank_name;
    private String account_number;
    private String account_name;
    private boolean account_yn;
}
