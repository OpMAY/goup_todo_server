package com.service.kream.shop.PurchaseService;


import com.dao.PurchaseDao;
import com.model.kream.order.before.Purchase;
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

    public List<Purchase> getMyPurchase(int user_no, LocalDate exdate) {
        LocalDate currentDate = LocalDate.now();
        boolean after = exdate.isAfter(currentDate);
        List<Purchase> purchaseList = purchaseDao.getMyPurchase(user_no,exdate,after);
        return purchaseList;
    }
}
