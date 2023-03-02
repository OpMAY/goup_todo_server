package com.dao;

import com.mapper.StyleMapper;
import com.model.kream.user.style.StyleUser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class StyleDao {

   private StyleMapper mapper;

   private StyleDao(SqlSession sqlSession){
       this.mapper = sqlSession.getMapper(StyleMapper.class);
   }

   public void registStyleUser(StyleUser styleUser){
       mapper.registStyleUser(styleUser);

   }
}
