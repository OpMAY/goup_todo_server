package com.controller;

import com.model.User;
import com.model.kream.cs.Notice;
import com.model.kream.cs.Qna;
import com.model.kream.home.Banner;
import com.model.kream.point.Point;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import com.service.NoticeService;
import com.service.QnaService;
import com.service.kream.user.PointService;
import com.service.kream.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final BannerService bannerService;
    private final UserService userService;
    private final PointService pointService;
    private final NoticeService noticeService;
    private final QnaService qnaService;

    @GetMapping("/banner")
    public ModelAndView getBanner(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<Banner> banners = bannerService.getAllBanner();
        view.addObject("banners", banners);

        message.put("banners",banners);

        return view;
    }

    @GetMapping("/user")
    public ModelAndView getUser(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<User> users = userService.getAllUser();
        view.addObject("users",users);

        return  view;
    }

    @GetMapping("/notice")
    public ModelAndView getNotice(@PathVariable int page){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<Notice> notices = noticeService.getNotices(page);
        view.addObject("notices",notices);

        return  view;
    }

    @GetMapping("/qna")
    public ModelAndView getNotice(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<Qna> qnas = qnaService.getAllQna();
        view.addObject("qnas",qnas);

        return  view;
    }








}
