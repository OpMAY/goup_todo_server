package com.service.kream.user;

import com.dao.AccountInfoDao;
import com.dao.CardInfoDao;
import com.model.kream.user.account.CardInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CardInfoService {
    private CardInfoDao cardInfoDao;

    public List<CardInfo> getCardInfo(int no) {
        return cardInfoDao.getCardInfo(no);
    }

    public void addCardInfo(CardInfo cardInfo){
        cardInfoDao.addCardInfo(cardInfo);
    }

    public void deleteCardInfo(int no) {
        cardInfoDao.deleteCardInfo(no);
    }

}
