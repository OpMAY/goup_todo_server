package com.dao;

import com.mapper.AccountInfoMapper;
import org.apache.ibatis.session.SqlSession;

public class AccountInfoDao {

    private AccountInfoMapper accountInfoMapper;

    private AccountInfoDao(SqlSession sqlSession){
        this.accountInfoMapper = sqlSession.getMapper(AccountInfoMapper.class);
    }


}
