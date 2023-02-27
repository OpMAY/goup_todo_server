package com.model.kream.style;

import com.model.common.Time;
import com.model.kream.product.Product;
import lombok.Data;

import java.util.List;

@Data
public class Style extends Time {
    private int no;
    private int style_user_no;
    private String content;
    private List<String> hashtag;

    // additional Data
    private List<Product> style_products;
}
