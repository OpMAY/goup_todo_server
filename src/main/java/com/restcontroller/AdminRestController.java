package com.restcontroller;

import com.model.kream.cs.Notice;
import com.model.kream.home.Banner;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream/admin")
public class AdminRestController {

    private final BannerService bannerService;

    @GetMapping("/banner")
    public ResponseEntity getNotice(){
        Message message = new Message();
        List<Banner> banners = bannerService.getBanner();
        message.put("banners",banners);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

}
