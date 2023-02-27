package com.dao;


import com.mapper.UserMapper;
import com.model.user.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private UserMapper userMapper;

    private UserDao(SqlSession sqlSession){
        this.userMapper = sqlSession.getMapper(UserMapper.class);
    }

    public void User(User user){
        userMapper.user(user);
    }
}
