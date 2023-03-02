package com.mapper;

import com.model.kream.user.account.AccountInfo;

public interface AccountInfoMapper {

    public void registAccountInfo(AccountInfo accountInfo);

    AccountInfo getAccountInfo(int user_no);

    void deleteAccountInfo(int user_no);

    void updateAccountInfo(AccountInfo accountInfo);
}
