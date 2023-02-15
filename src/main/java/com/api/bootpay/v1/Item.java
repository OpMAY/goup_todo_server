package com.api.bootpay.v1;

import lombok.Data;

/**
 * Created by ehowlsla on 2019. 8. 23..
 */
@Data
public class Item {
    public String item_name = "BootPay Test Item";
    public int qty;
    public String unique = "BP_Test_item_1";
    public long price = 1000;
    public String cat1;
    public String cat2;
    public String cat3;
}
