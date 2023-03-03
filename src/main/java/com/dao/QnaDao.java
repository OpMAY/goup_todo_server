package com.dao;

import com.mapper.QnAMapper;
import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
public class QnaDao {
    private QnAMapper mapper;

    private QnaDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(QnAMapper.class);
    }

    public Qna getQna(int no, QNA_TYPE type){
       return mapper.getQna(no,type);
    }



}
