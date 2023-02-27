package com.dao;

import com.mapper.StyleMapper;
import org.apache.ibatis.session.SqlSession;

public class StyleDao {

   private StyleMapper styleMapper;

   private StyleDao(SqlSession sqlSession){
       this.styleMapper = sqlSession.getMapper(StyleMapper.class);
   }
}
