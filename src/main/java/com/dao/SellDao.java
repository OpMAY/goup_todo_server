package com.dao;

import com.mapper.QnAMapper;
import com.mapper.SellMapper;
import org.apache.ibatis.session.SqlSession;

public class SellDao {
    private SellMapper  sellMapper ;

    private SellDao(SqlSession sqlSession){
        this.sellMapper = sqlSession.getMapper(SellMapper.class);
    }
}
