package com.restcontroller;

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
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("api/kream")
public class CsRestController {

    private final NoticeService noticeService;

    private final QnaService qnaService;



    @GetMapping("/notice/list")
    public ResponseEntity getNotice(@RequestParam int page){
        Message message = new Message();
//        List<Notice> notices = noticeService.getNotices(page);
        // Todo: list 형식으로 수정.

//        message.put("notices",notices);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/notice/list/detail")
    public ResponseEntity getNoticeDetail(@RequestParam int no){
        Message message = new Message();

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }



    @GetMapping("/qna/list")
    public ResponseEntity getQna(@RequestParam int no ,@RequestParam QNA_TYPE type) {
        Message message = new Message();

        Qna qna = qnaService.getQna(no,type);
        message.put("qna",qna);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/qna/list/detail")
    public ResponseEntity getQnaDetail (@RequestParam int no,  Pageable page){
        Message message = new Message();

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }





}
