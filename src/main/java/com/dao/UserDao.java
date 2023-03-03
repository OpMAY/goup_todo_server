package com.dao;


import com.mapper.UserMapper;
import com.model.User;
import com.model.common.MFile;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private UserMapper mapper;


    private UserDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(UserMapper.class);
    }

    public User getProfileInfo(int user_no){
       return mapper.getProfileInfo(user_no);

    }
    public void registUser(User user){
        mapper.registUser(user);
    }

    public void updateEmail(String email,int user_no){
        mapper.updateEmail(email,user_no);
    }
    public void updateUserName(String name,int user_no){
        mapper.updateUserName(name,user_no);
    }

    public void updatePhoneNumber(String phone_number,int user_no){
        mapper.updatePhoneNumber(phone_number,user_no);
    }

    public void updateSize(int size,int user_no){
        mapper.updateSize(size,user_no);
    }

    public void updateEmailAlarm(int email_alarm, int user_no){
        mapper.updateEmailAlarm(email_alarm,user_no);
    }

    public void updateReceiptInfo(User user){
        mapper.updateReceiptInfo(user);
    }



    public void updateProfileImage(MFile profile_image, int user_no  ){
        mapper.updateProfileImage(profile_image,user_no);
    }


    public void deletedUser(int no,int user_flag) {

        mapper.deleteUser(no,user_flag);
    }


}
