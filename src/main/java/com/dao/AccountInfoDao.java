package com.dao;

import com.mapper.AccountInfoMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class AccountInfoDao {

    private AccountInfoMapper mapper;

    private AccountInfoDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(AccountInfoMapper.class);
    }
}
