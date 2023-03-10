package com.mapper;

import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface QnAMapper {
    List<Qna> getQna(@Param("type") QNA_TYPE type);

    List<Qna> getAllQna();
}
