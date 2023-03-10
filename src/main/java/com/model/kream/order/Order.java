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

    public Order() {

    }

    public Order(int sell_no, int purchase_no, String order_number, ORDER_STATUS order_status, boolean order_flag) {
        this.sell_no = sell_no;
        this.purchase_no = purchase_no;
        this.order_number = order_number;
        this.order_status = order_status;
        this.order_flag = order_flag;
    }
}
