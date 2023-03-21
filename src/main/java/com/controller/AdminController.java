package com.controller;

import com.exception.ContentsException;
import com.model.kream.home.Banner;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
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
@RequestMapping("/api/kream/admin")
public class AdminController {

    private final BannerService bannerService;

    @PostMapping(value="/banner")
    public ResponseEntity registBanner(@RequestBody Banner banner) {
        Message message = new Message();
        if(banner.getNo() ==0){
            throw new ContentsException();
        }else{
            bannerService.registBanner(banner);
            message.put("status", true);
        }

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PutMapping("/banner/{no}")
    public ResponseEntity editBanner(@RequestBody Banner banner,@PathVariable int no) {
        Message message = new Message();
        if(banner.getNo() ==0){
            throw new ContentsException();
        }else{
            Map<String, Object> map = new HashMap<>();
            bannerService.editBanner(map,banner);
            message.put("status", true);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }




    @DeleteMapping("/banner/{no}")
    public ResponseEntity deleteBanner(@PathVariable int no) {
        Message message = new Message();

        bannerService.deleteBanner(no);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    
}
