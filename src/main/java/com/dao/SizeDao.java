package com.dao;

import com.mapper.SizeMapper;
import com.mapper.StyleMapper;
import org.apache.ibatis.session.SqlSession;

public class SizeDao {

   private SizeMapper sizeMapper;
   private SizeDao(SqlSession sqlSession){
       this.sizeMapper = sqlSession.getMapper(SizeMapper.class);
   }
}
