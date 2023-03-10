package com.restcontroller;

import com.model.kream.home.Banner;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/api/kream")
public class HomeController {
    private final BannerService bannerService;

    @GetMapping("/banner")
    public ResponseEntity getBanner(){
        Message message =new Message();
        List<Banner> bannerList = bannerService.getBanner();
        message.put("bannerlist",bannerList);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
