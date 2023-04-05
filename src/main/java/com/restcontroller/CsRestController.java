package com.restcontroller;

import com.exception.ContentsException;
import com.exception.HeaderAuthorizationTokenException;
import com.model.kream.cs.Notice;
import com.model.kream.cs.QNA_TYPE;
import com.model.kream.cs.Qna;
import com.response.DefaultRes;
import com.response.Message;
import com.service.NoticeService;
import com.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream")
public class CsRestController {

    private final NoticeService noticeService;

    private final QnaService qnaService;



    @GetMapping("/notice/{page}")
    public ResponseEntity getNotice(@PathVariable int page){
        Message message = new Message();
        List<Notice> notices = noticeService.getNotices(page);
        message.put("notices",notices);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/notice/detail/{no}")
    public ResponseEntity getNoticeDetail(@PathVariable int no){
        Message message = new Message();
        Notice notice = noticeService.getNotice(no);

        message.put("notice",notice);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }



    @GetMapping("/qna")
    public ResponseEntity getQna(@RequestParam(value="type",required = false) QNA_TYPE type) {
        Message message = new Message();

        List<Qna> qna ;
        if(type != null){
             qna= qnaService.getQnaByType(type);
        }else{
             qna = qnaService.getAllQna();

        }

        message.put("qna",qna);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/qna/{no}")
    public ResponseEntity getQnaDetail (@PathVariable int no){
        Message message = new Message();

        Qna qna =qnaService.getQnaData(no);
        message.put("qna",qna);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }







}
