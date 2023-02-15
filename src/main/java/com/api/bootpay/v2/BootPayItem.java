package com.api.bootpay.v2;

import lombok.Data;

@Data
public class BootPayItem {
    private String id = "BP_Test_item_1";
    private String name = "BootPay Test Item";
    private int qty;
    private int price = 1000;
}
