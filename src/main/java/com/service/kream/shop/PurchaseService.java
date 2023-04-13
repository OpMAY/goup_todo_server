package com.service.kream.shop;


import com.dao.PurchaseDao;
import com.model.kream.order.after.sub.DELIVERY_STATUS;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Purchase;
import com.model.kream.shop.PurchaseList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PurchaseService {

    private final PurchaseDao purchaseDao;

    public List<PurchaseList> getMyPurchase(int user_no, LocalDate exdate) {
        LocalDate currentDate = LocalDate.now();
        boolean after = exdate.isAfter(currentDate);
        List<PurchaseList> purchaseList = purchaseDao.getMyPurchase(user_no,exdate,after);
        return purchaseList;
    }

    public List<PurchaseList> getMyPurchaseByOrder(int user_no, DELIVERY_STATUS status, SELLSTOCK_TYPE type) {
         List<PurchaseList> purchaseList = purchaseDao.getMyPurchaseByOrder(user_no,status,type);
         return purchaseList;
    }

    public List<PurchaseList> getCompletePurchase(int user_no, DELIVERY_STATUS status) {
        List<PurchaseList> purchaseList = purchaseDao.getCompletePurchase(user_no,status);
        return purchaseList;
    }
}
