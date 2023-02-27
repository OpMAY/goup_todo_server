package com.model.kream.order.before;

import com.model.common.Time;
import com.model.kream.order.before.sub.common.CashReceipt;
import com.model.kream.order.before.sub.common.DELIVERY_METHOD;
import com.model.kream.order.before.sub.common.OrderAddressInfo;
import com.model.kream.order.before.sub.common.OrderBankInfo;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import com.model.kream.order.before.sub.sell.SellAgreeData;
import com.model.kream.order.before.sub.sell.SellOrderAgreeData;
import lombok.Data;

import java.time.LocalDate;

@Data
public class Sell extends Time {
    private int no;
    private int user_no;
    private int size_no;
    private SellAgreeData sell_agree;
    private SellOrderAgreeData s_order_agree;
    private SELL_TYPE sell_type;
    private LocalDate expiration_date;
    private int expiration_days;
    private int price;
    private int inspection_price;
    private int delivery_price;
    private int commission;
    private int total_price;
    private OrderBankInfo bank_info;
    private OrderAddressInfo recall_address_info;
    private DELIVERY_METHOD recall_method;
    private CashReceipt cash_receipt;
    private boolean s_bid_flag;
}
