package com.model.kream.product.interactions;

import lombok.Data;

import java.util.List;

@Data
public class WishRequest {
    private int user_no;
    private int product_no;
    private List<Wish> wishes;
}
