package com.model.kream.order.before.sub.purchase;

import com.api.bootpay.BootPayDefaultModel;
import com.model.common.Time;
import lombok.Data;

@Data
public class Receipt extends Time {
    private final BootPayDefaultModel receipt_bootpay;
}
