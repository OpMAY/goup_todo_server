package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.model.common.MFile;
import com.model.jwt.RootUser;
import com.model.kream.user.LOGIN_TYPE;
import lombok.*;

import java.util.Date;

@RequiredArgsConstructor
@Data
@AllArgsConstructor
@JsonIgnoreProperties
@ToString(callSuper = true)
public class User extends RootUser {
    private int no;
    private String name;
    private String access_token;
    private String phone_number;
    private int size;
    private int point;
    private int email_alarm;
    private String zipcode;
    private String address;
    private String address_detail;
    private LOGIN_TYPE login_type;
    private Date last_login_datetime;
    private MFile profile_img;
    private Date updated_datetime;
    private String email;
    private String cash_receipt_type;
    private String cr_card_number;
    private String cr_phone_number;
    private int cr_alarm_agree;
    private int user_flag;

}
