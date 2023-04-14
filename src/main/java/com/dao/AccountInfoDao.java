package com.dao;

import com.mapper.AccountInfoMapper;

import com.model.kream.user.account.AccountInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountInfoDao {

    private AccountInfoMapper mapper;

    private AccountInfoDao(SqlSession sqlSession)  {
        this.mapper = sqlSession.getMapper(AccountInfoMapper.class);
    }

    public AccountInfo  getAccountInfo(int user_no){
        return mapper.getAccountInfo(user_no);
    }

    public void registAccountInfo(AccountInfo accountInfo){
        mapper.registAccountInfo(accountInfo);

    }

    public void updateAccountInfo(AccountInfo accountInfo){
        mapper.updateAccountInfo(accountInfo);
    }

    public void deleteAccountInfo(int user_no){
        mapper.deleteAccountInfo(user_no);
    }


}
