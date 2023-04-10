package com.model.kream.product.interactions;

import com.model.common.MFile;
import com.model.kream.product.Product;
import com.model.kream.product.brand.Brand;
import com.model.kream.product.size.Size;
import lombok.Data;

@Data
public class WishList {
    private int user_no;
    private MFile images;
    private String size;
    private String en_name;
    private String name;

}
