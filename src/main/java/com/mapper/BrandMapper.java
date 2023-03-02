package com.mapper;

import com.model.kream.product.brand.Brand;

public interface BrandMapper {
    Brand getBrandByNo(int no);

    Brand getBrandByProductNo(int no);
}
