package com.mapper;

import com.model.kream.product.brand.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BrandMapper {
    Brand getBrandByNo(int no);

    Brand getBrandByProductNo(int no);

    List<Brand> getAllBrands();

    void updateBrand(Brand brand);

    void makeBrand(Brand brand);

    boolean isNameDuplicated(@Param("no") int no, @Param("name") String name);

    void deleteBrand(int no);
}
