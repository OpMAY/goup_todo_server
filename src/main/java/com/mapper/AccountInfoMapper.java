package com.mapper;

import com.model.kream.user.account.AccountInfo;

import java.util.List;

public interface AccountInfoMapper {

    void registAccountInfo(AccountInfo accountInfo);

    AccountInfo getAccountInfo(int user_no);

    void deleteAccountInfo(int user_no);

    void updateAccountInfo(AccountInfo accountInfo);
}
