package com.model.kream.user.address;

import lombok.Data;

@Data
public class Address {
    private int no;
    private int user_no;
    private String name;
    private String phone_number;
    private String zip_code;
    private String address;
    private String address_detail;
    private boolean is_default_address;

}
