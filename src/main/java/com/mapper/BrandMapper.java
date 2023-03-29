package com.mapper;

import com.model.kream.product.brand.Brand;

import java.util.List;

public interface BrandMapper {
    Brand getBrandByNo(int no);

    Brand getBrandByProductNo(int no);

    List<Brand> getAllBrands();
}
