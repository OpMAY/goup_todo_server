package com.service;

import com.dao.NoticeDao;
import com.dao.QnaDao;
import com.model.kream.cs.Notice;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j

public class NoticeService {

    private final NoticeDao noticeDao;
    private final QnaDao qnaDao;

    public Notice getNotice(int no) {
        return noticeDao.getNotice(no);
    }


//    public List<Notice> getNotices(int page) {
//        if (page <= 0) {
//            page = 1;
//        }
//        List<Notice> notices = noticeDao.getNotices(page);
//    }

}
