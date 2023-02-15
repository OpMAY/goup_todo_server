package com.api.bootpay;

import lombok.Data;

@Data
public class BootPayCancelModel {
    private String method;
    private String receiptId;
}
