package com.service.kream.user;

import com.dao.AccountInfoDao;
import com.model.kream.user.account.AccountInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class AccountInfoService {

    private final AccountInfoDao accountInfoDao;

    public AccountInfo getAccountInfo(int user_no){
       return accountInfoDao.getAccountInfo(user_no);

    }

    @Transactional
    public void registAccountInfo(AccountInfo accountInfo){
        accountInfoDao.registAccountInfo(accountInfo);

    }

    @Transactional
    public void updateAccountInfo(AccountInfo accountInfo){
        accountInfoDao.updateAccountInfo(accountInfo);
    }

    @Transactional
    public void deleteAccountInfo(int user_no){
        accountInfoDao.deleteAccountInfo(user_no);
    }


}
