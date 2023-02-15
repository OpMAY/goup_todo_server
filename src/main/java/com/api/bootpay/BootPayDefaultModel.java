package com.api.bootpay;

import com.api.bootpay.v1.BootPay;
import com.api.bootpay.v2.BootPayV2;
import lombok.Data;

@Data
public class BootPayDefaultModel {
    private String method;
    private BootPay bootPayV1;
    private BootPayV2 bootPayV2;
}
