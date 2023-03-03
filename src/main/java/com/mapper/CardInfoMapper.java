package com.mapper;

import com.model.kream.user.account.CardInfo;

import java.util.List;

public interface CardInfoMapper {
    List<CardInfo> getCardInfo(int no);
    void addCardInfo(CardInfo cardInfo);
    void deleteCardInfo(int no);


}
