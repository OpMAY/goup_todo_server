package com.dao;

import com.mapper.QnAMapper;
import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class QnaDao {
    private QnAMapper mapper;

    private QnaDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(QnAMapper.class);
    }

    public List<Qna> getQna(QNA_TYPE type){
       return mapper.getQna(type);
    }


    public List<Qna> getAllQna() {
        return mapper.getAllQna();
    }
}
