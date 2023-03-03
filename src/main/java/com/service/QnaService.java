package com.service;

import com.dao.QnaDao;
import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class QnaService {
    private final QnaDao qnaDao;

    public Qna getQna(int no , QNA_TYPE type) {
        return qnaDao.getQna(no,type);
    }


}
