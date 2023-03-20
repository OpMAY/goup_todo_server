package com.mapper;

import com.model.User;
import com.model.common.MFile;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    User getProfileInfo(int no);

    void registUser(User user); //user 등록

    void deleteUser(@Param("no") int no, @Param("user_flag") int user_flag); //user.user_flag 0으로 변경

    void updateUser(User user); //user info 변경

    void updateEmail(@Param("email") String email, @Param("no") int user_no);

    void updateUserName(@Param("name") String name, @Param("no") int no);

    void updatePhoneNumber(@Param("phone_number") String phone_number, @Param("no") int no);

    void updateSize(@Param("size") int size, @Param("no") int no);

    void updateEmailAlarm(@Param("email_alarm") int email_alarm, @Param("no") int no);

    void updateReceiptInfo(User user);

    void updateProfileImage(@Param("profile_image") MFile profile_image, @Param("user_no")int user_no);


    User getUserbyToken(String access_token);
}
