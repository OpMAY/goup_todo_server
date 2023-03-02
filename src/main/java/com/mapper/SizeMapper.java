package com.mapper;

import com.model.kream.product.size.Size;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SizeMapper {
    List<Size> getProductSize(int product_no);

    boolean isProductOneSize(int product_no);

    void insertProductSize(Size size);

    void deleteSizeByNo(int no);

    void deleteSizeByProductNoAndSize(@Param("product_no") int product_no, @Param("size") String size);

    void updateSize(@Param("no") int no, @Param("size") String size);
}
