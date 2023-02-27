package com.model.kream.order.before.sub.common;

import lombok.Data;

@Data
public class CashReceipt {
    private CASH_RECEIPT_TYPE type;
    private String value;
}
