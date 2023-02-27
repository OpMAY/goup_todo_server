package com.model.kream.product.interactions;

import com.model.common.Time;
import lombok.Data;

@Data
public class Wish extends Time {
    private int no;
    private int user_no;
    private int size_no;
}
