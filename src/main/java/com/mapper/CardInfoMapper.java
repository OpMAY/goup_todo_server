package com.mapper;

import com.model.kream.user.account.CardInfo;

public interface CardInfoMapper {
    CardInfo getCardInfo(int user_no);
    void addCardInfo(CardInfo cardInfo);
    void deleteCardInfo(int no);


}
