package com.mapper;

import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface QnAMapper {
    List<Qna> getQnaByType(@Param("type") QNA_TYPE type);

    List<Qna> getAllQna();

    Qna  getQnaData(int no);

    void addQna(Qna qna);

    void updateQna(Map<String, Object> data);

    void deleteQna(int no);


}
