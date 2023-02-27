package com.mapper;

import com.model.User;

public interface UserMapper {
    User getProfileInfo(int user_no);

    void registUser(User user); //user 등록


    void updateUser(User user); //user info 변경

    void deleteUser(int no, String access_token); //user 삭제


}
