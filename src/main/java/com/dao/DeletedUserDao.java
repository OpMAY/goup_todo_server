package com.dao;

import com.mapper.DeletedUserMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class DeletedUserDao {
    private DeletedUserMapper mapper;

    private DeletedUserDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(DeletedUserMapper.class);
    }
}
