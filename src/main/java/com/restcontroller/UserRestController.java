package com.restcontroller;

import com.api.LoginAPI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.User;
import com.model.kream.point.Point;
import com.model.kream.user.account.AccountInfo;
import com.model.kream.user.account.CardInfo;
import com.model.kream.user.address.Address;
import com.model.kream.user.style.StyleUser;
import com.response.DefaultRes;
import com.response.Message;
import com.service.kream.user.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream/my")
public class UserRestController {

    @Value("${KAKAO.JAVASCRIPT}")
    private String KAKAO_JAVASCRIPT;

    @Value("${NAVER.CLIENT_ID}")
    private String NAVER_CLIENT_ID;

    @Value("${GOOGLE.CLIENT_ID}")
    private String GOOGLE_CLIENT_ID;

    private final UserService userService;
    private final AddressService addressService;
    private final AccountInfoService accountInfoService;
    private final CardInfoService cardInfoService;

    private final PointService pointService;
    private final LoginAPI loginAPI;


    @GetMapping("/user/{no}")
    public ResponseEntity getUserList(HttpServletRequest request, HttpServletResponse response, @PathVariable int no) {
        Message message = new Message();
        User user = userService.getProfileInfo(no);
        message.put("user", user);
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


    @PutMapping("/profile/{no}")
    public ResponseEntity userEdit(@RequestBody User  user, @PathVariable int no
    ) throws JsonProcessingException {
        Message message = new Message();
        userService.updateProfile(user, message);
        message.put("status", true);
        message.put("user",user);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @DeleteMapping("/profile/{no}")
    public ResponseEntity userDelete(@PathVariable int no) {
        Message message = new Message();
        userService.deleteUser(no);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/address/{user_no}")
    public ResponseEntity getAddresses(@PathVariable int user_no) {
        Message message = new Message();
        List<Address> address = addressService.getAddressInfo(user_no);

        message.put("address", address);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping("/address")
    public ResponseEntity registAddress(@RequestBody Address address) {
        Message message = new Message();
        addressService.registAddress(address);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/address/{no}")
    public ResponseEntity editAddress(@RequestBody Address address, @PathVariable int no) {
        Message message = new Message();
        addressService.updateAddress(address);
        message.put("status", true);
        message.put("address",address);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK,message), HttpStatus.OK);
    }

    @DeleteMapping("/address/{no}")
    public ResponseEntity deleteAddress(@PathVariable int no) {

        Message status = addressService.deleteAddress(no);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, status, true), HttpStatus.OK);
    }

    @GetMapping("/account/{no}")
    public ResponseEntity getAccountInfo(@PathVariable int no) {
        Message message = new Message();
        List<AccountInfo> accountInfo = accountInfoService.getAccountInfo(no);
        message.put("accountInfo", accountInfo);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity registAccountInfo(@RequestBody AccountInfo accountInfo) {
        Message message = new Message();
        accountInfoService.registAccountInfo(accountInfo);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/account/{user_no}")
    public ResponseEntity editAccountInfo(@RequestBody AccountInfo accountInfo, @PathVariable int user_no) {
        Message message = new Message();
        accountInfoService.updateAccountInfo(accountInfo);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @DeleteMapping("/account/{user_no}")
    public ResponseEntity deleteAccountInfo(@PathVariable int user_no) {
        Message message = new Message();
        accountInfoService.deleteAccountInfo(user_no);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/payment/{user_no}")
    public ResponseEntity getListPayment(@PathVariable int user_no) {
        Message message = new Message();

        List<CardInfo> cardInfo = cardInfoService.getCardInfo(user_no);
        message.put("cardInfo", cardInfo);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PostMapping("/payment")
    public ResponseEntity registPayment(@RequestBody CardInfo cardInfo) {
        Message message = new Message();
        cardInfoService.addCardInfo(cardInfo);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @DeleteMapping("/payment/{no}")
    public ResponseEntity deleteCardInfo(@PathVariable int no) {
        Message message = new Message();
        cardInfoService.deleteCardInfo(no);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/receipt/{no}")
    public ResponseEntity getReceiptList(@PathVariable int no) {
        Message message = new Message();
        User user = userService.getProfileInfo(no);
        Map<String, Object> map = new HashMap<>();
        map.put("cash_receipt_type", user.getCash_receipt_type());
        map.put("cr_card_number", user.getCash_receipt_type());
        map.put("cr_phone_number", user.getCash_receipt_type());
        map.put("cr_alarm_agree", user.getCash_receipt_type());

        message.put("receiptInfo", map);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/point/{no}")
    public ResponseEntity getPointList(@PathVariable int no) {
        Message message = new Message();

        List<Point> point = pointService.getPoint(no);
        message.put("point", point);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PostMapping("/point")
    public ResponseEntity RegistPoint(@RequestBody Point point) {
        Message message = new Message();
        pointService.registPoint(point);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }


}

