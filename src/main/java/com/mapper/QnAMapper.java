package com.mapper;

import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import org.apache.ibatis.annotations.Param;

public interface QnAMapper {
    Qna getQna(@Param("no") int no, @Param("type") QNA_TYPE type);

}
