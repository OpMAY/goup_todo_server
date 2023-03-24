package com.restcontroller;

import com.model.kream.cs.Notice;
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

import java.util.HashMap;
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
    public ResponseEntity registNotice(@PathVariable int no  ){
        Message message  = new Message();
        Notice notice = noticeService.getNotice(no);

        Map<String,Object> data = new HashMap<>();
        data.put("no",notice.getNo());
        data.put("title",notice.getTitle());
        data.put("content",notice.getContent());
        data.put("flag",notice.isFlag());
        noticeService.updateNotice(data);
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
        qnaService.addQna(qna);
        message.put("notice",true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/qna/{no}")
    public ResponseEntity updateQna(@PathVariable int no){
        Qna qna = qnaService.getQnaData(no);
        Message message  = new Message();

        Map<String, Object> data = new HashMap<>();
        data.put("no",qna.getNo());
        data.put("title",qna.getTitle());
        data.put("content",qna.getContent());
        data.put("type",qna.getType());
        data.put("updated_datetime",qna.getUpdated_datetime());

        qnaService.updateQna(data);
        message.put("notice",true);
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
