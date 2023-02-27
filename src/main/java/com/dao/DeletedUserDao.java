package com.dao;

import com.mapper.DeletedUserMapper;
import org.apache.ibatis.session.SqlSession;

public class DeletedUserDao {
    private DeletedUserMapper deletedUserMapper;

    private DeletedUserDao(SqlSession sqlSession){
        this.deletedUserMapper = sqlSession.getMapper(DeletedUserMapper.class);
    }
}
