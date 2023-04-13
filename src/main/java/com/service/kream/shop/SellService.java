package com.service.kream.shop;

import com.dao.SellDao;
import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Sell;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SellService {

    private final SellDao sellDao;

    public List<Sell> getMySell(int user_no,LocalDate expiration_date ){
        LocalDate currentDate = LocalDate.now();
        boolean after = expiration_date.isAfter(currentDate);
        List<Sell> sellList =sellDao.getMySell(user_no,expiration_date,after);

        return sellList;
    }

    public List<Sell> getMySelleEnd(int user_no, LocalDate expiration_date){
        return sellDao.getMySellEnd(user_no,expiration_date);
    }

    public List<Sell> getMySellByOrder(int user_no, SELLSTOCK_TYPE status, INSPECTION_TYPE type, ORDER_STATUS order_status){
        return sellDao.getMySellByOrder(user_no,status,type,order_status);
    }

    public List<Sell> getMySellNotByOrder(int user_no, SELL_TYPE sell_type){
        return sellDao.getMySellNotByOrder(user_no,sell_type);
    }
}
