package com.controller;

import com.model.kream.home.Banner;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
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

    @GetMapping("/banner")
    public ModelAndView getBanner(){
        Message message = new Message();
        List<Banner> banners = bannerService.getBanner();
        message.put("banners",banners);
        return new ModelAndView("/");
    }





}
