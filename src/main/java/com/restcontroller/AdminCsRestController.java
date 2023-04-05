package com.restcontroller;

import com.model.kream.cs.Notice;
import com.model.kream.cs.Qna;
import com.response.DefaultRes;
import com.response.Message;
import com.service.NoticeService;
import com.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.weaver.ast.Not;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream/admin/cs")
public class AdminCsRestController {
    private final NoticeService noticeService;
    private final QnaService qnaService;




    @PostMapping("/notice")
    public ResponseEntity registNotice(@RequestBody Notice notice){
        Message message  = new Message();
        noticeService.addNotice(notice);
        message.put("notice",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/notice/{no}")
    public ResponseEntity editNotice(@PathVariable int no, @RequestBody Notice notice){
        Message message  = new Message();

        log.info("{}",notice);
        noticeService.updateNotice(notice);
        message.put("notice",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @DeleteMapping("/notice/{no}")
    public ResponseEntity deleteNotice(@PathVariable int no  ){
        Message message  = new Message();
        noticeService.deleteNotice(no);

        message.put("notice",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PostMapping("/qna")
    public ResponseEntity registQna(@RequestBody Qna qna){
        Message message  = new Message();
        log.info("{}",qna);
        qnaService.addQna(qna);
        message.put("qna",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/qna/{no}")
    public ResponseEntity updateQna(@PathVariable int no, @RequestBody Qna data){
        System.out.println(data);
        Message message  = new Message();

        qnaService.updateQna(data);
        message.put("qna",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @DeleteMapping("/qna/{no}")
    public ResponseEntity deleteQna(@PathVariable int no){
        Message message  = new Message();
        qnaService.deleteQna(no);
        message.put("qna",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }


}
