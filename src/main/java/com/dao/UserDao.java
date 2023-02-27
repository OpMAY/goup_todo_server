package com.dao;


import com.mapper.UserMapper;
import com.model.user.User;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    private UserMapper mapper;

    private UserDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(UserMapper.class);
    }

    public void User(User user){
        mapper.user(user);
    }
}
