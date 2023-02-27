package com.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.model.common.MFile;
import com.model.jwt.RootUser;
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
    private String login_type;
    private Date last_login_datetime;
    private MFile profile_img;

}
