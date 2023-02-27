package com.dao;

import com.mapper.SizeMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class SizeDao {

   private SizeMapper mapper;
   private SizeDao(SqlSession sqlSession){
       this.mapper = sqlSession.getMapper(SizeMapper.class);
   }
}
