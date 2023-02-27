package com.model.kream.product.category;

import com.model.common.Time;
import lombok.Data;

@Data
public class Category  extends Time {
    private int no;
    private int parent_no;
    private String name;
}
