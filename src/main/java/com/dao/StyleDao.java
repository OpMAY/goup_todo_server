package com.dao;

import com.mapper.StyleMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleDao {

   private StyleMapper mapper;

   private StyleDao(SqlSession sqlSession){
       this.mapper = sqlSession.getMapper(StyleMapper.class);
   }
}
