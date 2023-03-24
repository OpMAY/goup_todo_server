package com.dao;

import com.mapper.QnAMapper;
import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class QnaDao {
    private QnAMapper mapper;

    private QnaDao(SqlSession sqlSession){
        this.mapper = sqlSession.getMapper(QnAMapper.class);
    }

    public List<Qna> getQnaByType(QNA_TYPE type){
       return mapper.getQnaByType(type);
    }


    public List<Qna> getAllQna() {
        return mapper.getAllQna();
    }

    public Qna getQnaData(int no) {
        return mapper.getQnaData(no);

    }

    public void addQna(Qna qna) {
        mapper.addQna(qna);
    }

    public void updateQna(Map<String, Object> data) {
        mapper.updateQna(data);
    }

    public void deleteQna(int no) {
        mapper.deleteQna(no);
    }


}
