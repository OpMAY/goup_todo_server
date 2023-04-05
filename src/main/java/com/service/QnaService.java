package com.service;

import com.dao.QnaDao;
import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Service
@Slf4j
public class QnaService {
    private final QnaDao qnaDao;

    public List<Qna> getQnaByType( QNA_TYPE type) {
        return qnaDao.getQnaByType(type);
    }


    public List<Qna> getAllQna() {
        return qnaDao.getAllQna();
    }

    public Qna getQnaData(int no) {
        return qnaDao.getQnaData(no);
    }

    public void addQna(Qna qna){
        qnaDao.addQna(qna);
    }

    public void updateQna(Qna qna){


        qnaDao.updateQna(qna);


    }

    public void deleteQna(int no) {
        qnaDao.deleteQna(no);
    }


}
