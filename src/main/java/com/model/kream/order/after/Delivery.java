package com.model.kream.order.after;

import com.model.common.Time;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import lombok.Data;

@Data
public class Delivery extends Time {
    private int order_no;
    private String delivery_company;
    private String delivery_number;
    private DELIVERY_STATUS status;
}
