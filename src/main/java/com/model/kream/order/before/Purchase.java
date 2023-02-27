package com.model.kream.order.before;

import com.model.common.Time;
import com.model.kream.order.before.sub.common.DELIVERY_METHOD;
import com.model.kream.order.before.sub.common.OrderAddressInfo;
import com.model.kream.order.before.sub.purchase.PURCHASE_TYPE;
import com.model.kream.order.before.sub.purchase.PurchaseAgreeData;
import com.model.kream.order.before.sub.purchase.PurchaseOrderAgreeData;
import com.model.kream.order.before.sub.purchase.Receipt;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Purchase extends Time {
    private int no;
    private int user_no;
    private int size_no;
    private PurchaseAgreeData purchase_agree;
    private PurchaseOrderAgreeData p_order_agree;
    private PURCHASE_TYPE purchase_type;
    private LocalDate expiration_date;
    private int expiration_days;
    private int price;
    private OrderAddressInfo delivery_info;
    private DELIVERY_METHOD delivery_method;
    private int point;
    private int commission;
    private int delivery_price;
    private int total_price;
    private String payment_method;
    private Receipt receipt;
    private boolean p_bid_flag;
}
