package com.model.kream.user.account;

import lombok.Data;

import java.util.Date;

@Data
public class CardInfo {
    private int no;
    private int user_no;
    private String card_company;
    private String card_number;
    private String card_expiration_date;
    private Date birth_date;
    private int password;
}
