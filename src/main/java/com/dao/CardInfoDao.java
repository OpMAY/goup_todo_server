package com.dao;

import com.mapper.CardInfoMapper;
import com.model.kream.user.account.CardInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CardInfoDao {

    private CardInfoMapper mapper;

    private CardInfoDao(SqlSession sqlSession) {
        this.mapper = sqlSession.getMapper(CardInfoMapper.class);
    }

    public List<CardInfo> getCardInfo(int no) {
        return mapper.getCardInfo(no);
    }

    @Transactional
    public void addCardInfo(CardInfo cardInfo){
        mapper.addCardInfo(cardInfo);
    }
    @Transactional
    public void deleteCardInfo(int no) {
        mapper.deleteCardInfo(no);
    }


}
