package com.model.kream.order.after;

import com.model.common.Time;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import lombok.Data;

@Data
public class SellStock extends Time {
    private int order_no;
    private String invoice_number;
    private String invoice_company;
    private boolean status;
    private SELLSTOCK_TYPE type;
}
