package com.controller;

import com.model.kream.cs.Notice;
import com.model.kream.cs.Qna;
import com.model.kream.home.Banner;
import com.response.Message;
import com.service.NoticeService;
import com.service.QnaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/cs")
public class AdminCsController {
    private final NoticeService noticeService;
    private final QnaService qnaService;

    @GetMapping("/notice")
    public ModelAndView getNotice(@PathVariable int page){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin");

        List<Notice> notices = noticeService.getNotices(page);
        view.addObject("notices", notices);

        message.put("notices",notices);

        return view;
    }

    @GetMapping("/qna")
    public ModelAndView getQna(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin");

        List<Qna> qnas = qnaService.getAllQna();
        view.addObject("qnas",qnas);

        message.put("qnas",qnas);
        return view;
    }
}
