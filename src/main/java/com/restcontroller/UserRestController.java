package com.restcontroller;

import com.api.LoginAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.middleware.JsonObjectTypeHandler;
import com.model.User;
import com.model.common.MFile;
import com.model.kream.user.address.Address;
import com.model.kream.user.style.StyleUser;
import com.response.DefaultRes;
import com.response.Message;
import com.service.kream.user.AddressService;
import com.service.kream.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Set;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream")
public class UserRestController {

    @Value("${KAKAO.JAVASCRIPT}")
    private String KAKAO_JAVASCRIPT;

    @Value("${NAVER.CLIENT_ID}")
    private String NAVER_CLIENT_ID;

    @Value("${GOOGLE.CLIENT_ID}")
    private String GOOGLE_CLIENT_ID;

    private final UserService userService;
    private final AddressService addressService;
    private final LoginAPI loginAPI;


    @RequestMapping(value = "/sns/key/{type}", method = RequestMethod.POST)
    public ResponseEntity getKey(HttpServletRequest request, @PathVariable String type
    ) {
        Message message = new Message();
        switch (type) {
            case "kakao":
                message.put("clientId", KAKAO_JAVASCRIPT);
                break;

            case "naver":
                message.put("clientId", NAVER_CLIENT_ID);
                break;
//
            case "google":
                message.put("clientId", GOOGLE_CLIENT_ID);
                break;

            default:
                return new ResponseEntity(DefaultRes.res(HttpStatus.BAD_REQUEST), HttpStatus.OK);
        }

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity getUserList(HttpServletRequest request, HttpServletResponse response, int no){
        Message message  = new Message();
        message.put("result",userService.getProfileInfo(no));

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public ResponseEntity join(HttpServletRequest request) {
        Message message = new Message();

        User user = loginAPI.apiLoginInit(request);
        StyleUser styleUser = new StyleUser();

        userService.registUser(user, styleUser);

        message.put("user", user);
        message.put("styleUser", styleUser);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    /*
    user 정보 수정
     1.수정된 data 받기
     2.
    * */
    @PutMapping("/profile/{no}")
    public ResponseEntity userEdit(@PathVariable int no, @RequestBody Map<String, Object> data
    ) throws JsonProcessingException {
        Message message = new Message();
        userService.updateProfile(data, no, message);

        message.put("result", "회원 정보 수정 완료");
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @DeleteMapping("/profile/{no}")
    public ResponseEntity userDelete(@PathVariable int no) {
        Message message = new Message();

        userService.deleteUser(no);
        message.put("result","회원탈퇴 완료");

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/address/list")
    public ResponseEntity getAddresses(@PathVariable int no) {
        Message message = new Message();

        message.put("result", addressService.getAddressInfo(no));

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping("/address/regist")
    public ResponseEntity registAddress(@RequestBody Address address){
       Message message = new Message();
       addressService.registAddress(address);
        message.put("status",address !=null);


        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping
    public ResponseEntity editAddress(@RequestBody Address address){

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/address/{no}")
    public ResponseEntity deleteAddress(int no){
        Message message = new Message();
        message.put("status", addressService.getAddressInfo(no));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }



}

