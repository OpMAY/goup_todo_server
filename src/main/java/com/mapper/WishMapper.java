package com.mapper;

import com.model.kream.product.interactions.Wish;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WishMapper {
    int getProductWishCount(int product_no);

    List<Wish> getUserWishes(int user_no);

    void insertUserWish(Wish wish);

    void deleteUserWishByNo(int no);

    void deleteUserWishByUserNoAndSizeNo(@Param("user_no") int user_no, @Param("size_no") int size_no);

    boolean isUserWishProduct(@Param("product_no") int product_no, @Param("user_no") int user_no);

    boolean isUserWishSize(@Param("user_no") int user_no, @Param("size_no") int size_no);
}
