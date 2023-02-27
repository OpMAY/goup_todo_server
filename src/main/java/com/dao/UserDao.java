package com.dao;


import com.mapper.UserMapper;
import com.model.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

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

    public void updateUser(User user){
        mapper.updateUser(user);
    }

    public void deleteUser(int no, String access_token) {
        mapper.deleteUser(no,access_token);
    }


}
