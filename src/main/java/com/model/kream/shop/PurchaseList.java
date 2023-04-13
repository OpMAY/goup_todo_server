package com.model.kream.shop;

import com.model.common.MFile;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PurchaseList {
    private int no;
    private DELIVERY_STATUS status;
    private SELLSTOCK_TYPE type;
    private MFile images;
    private String en_name;
    private String kor_name;
    private String size;
    private LocalDate expiration_date;
}
