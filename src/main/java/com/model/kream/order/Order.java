package com.model.kream.order;

import com.model.common.Time;
import lombok.Data;

@Data
public class Order extends Time {
    private int no;
    private int sell_no;
    private int purchase_no;
    private String order_number;
    private ORDER_STATUS order_status;
    private boolean order_flag;
}
