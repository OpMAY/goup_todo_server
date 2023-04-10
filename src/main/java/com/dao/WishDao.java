package com.dao;


import com.mapper.WishMapper;
import com.model.kream.product.interactions.Wish;
import com.model.kream.product.interactions.WishList;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class WishDao {
    private WishMapper mapper;

    private WishDao(SqlSession sqlSession){
        this.mapper =sqlSession.getMapper(WishMapper.class);
    }

    public int getProductWishCount(int product_no) {
        return mapper.getProductWishCount(product_no);
    }

    public List<Wish> getUserWishes(int user_no) {
        return mapper.getUserWishes(user_no);
    }

    public void insertUserWish(Wish wish) {
        mapper.insertUserWish(wish);
    }

    public void deleteUserWishByNo(int no) {
        mapper.deleteUserWishByNo(no);
    }

    public void deleteUserWishByUserNoAndSizeNo(int user_no, int size_no) {
        mapper.deleteUserWishByUserNoAndSizeNo(user_no, size_no);
    }

    public boolean isUserWishProduct(int product_no, int user_no) {
        return mapper.isUserWishProduct(product_no, user_no);
    }

    public boolean isUserWishSize(int user_no, int size_no) {
        return mapper.isUserWishSize(user_no, size_no);
    }

    public void resetUserProductWishes(int user_no, int product_no) {
        mapper.resetUserProductWishes(user_no, product_no);
    }

    public List<WishList> getMywishList(int user_no) {
        return mapper.getMywishList(user_no);
    }
}
