package com.dao;

import com.mapper.PurchaseMapper;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Purchase;
import com.model.kream.product.price.ProductPriceWithSizeAndCount;
import com.model.kream.shop.PurchaseList;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class PurchaseDao {
    private PurchaseMapper mapper;

    private PurchaseDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(PurchaseMapper.class);
    }

    public List<ProductPriceWithSizeAndCount> getProductPurchaseHistory(int product_no) {
        return mapper.getProductPurchaseHistory(product_no);
    }

    public Integer getSizeProductPurchaseHighestPrice(int size_no) {
        return mapper.getSizeProductPurchaseHighestPrice(size_no);
    }

    public Purchase getPurchaseForOrder(int size_no, int price) {
        return mapper.getPurchaseForOrder(size_no, price);
    }

    public void registerPurchase(Purchase purchase) {
        mapper.registerPurchase(purchase);
    }

    public List<PurchaseList> getMyPurchase(int user_no, LocalDate expiration_date, boolean after) {
       return mapper.getMyPurchase(user_no,expiration_date,after);

    }


    public List<PurchaseList> getMyPurchaseByOrder(int user_no, DELIVERY_STATUS status, SELLSTOCK_TYPE type) {
        return mapper.getMyPurchaseByOrder( user_no,  status,type);
    }

    public List<PurchaseList> getCompletePurchase(int user_no, DELIVERY_STATUS status) {
        return mapper.getCompletePurchase(user_no,status);
    }
}
