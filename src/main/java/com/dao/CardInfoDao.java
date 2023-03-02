package com.dao;

import com.mapper.CardInfoMapper;
import com.model.kream.user.account.CardInfo;
import org.apache.ibatis.session.SqlSession;

public class CardInfoDao {

    private CardInfoMapper mapper;

    private CardInfoDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(CardInfoMapper.class);
    }

    public CardInfo getCardInfo(int user_no) {
        return mapper.getCardInfo(user_no);
    }

    public void addCardInfo(CardInfo cardInfo){
        mapper.addCardInfo(cardInfo);
    }

    public void deleteCardInfo(int no) {
        mapper.deleteCardInfo(no);
    }


}
