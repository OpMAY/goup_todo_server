package com.restcontroller;

import com.api.LoginAPI;
import com.aws.file.FileUploadUtility;
import com.aws.model.CDNUploadPath;
import com.exception.ContentsException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.User;
import com.model.common.MFile;
import com.model.kream.point.Point;
import com.model.kream.user.LOGIN_TYPE;
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
import org.springframework.web.multipart.MultipartFile;

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
    private final FileUploadUtility fileUploadUtility;


    @GetMapping("/user/{no}")
    public ResponseEntity getUserList(HttpServletRequest request, HttpServletResponse response, @PathVariable int no) {
        Message message = new Message();
        User user = userService.getProfileInfo(no); // 해당 no 사용자 데이터 가져오기
        message.put("user", user);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @RequestMapping(value = "/join", method = RequestMethod.POST)
    public ResponseEntity join(HttpServletRequest request, @RequestBody User user_model) {
        Message message = new Message();
        boolean exist = userService.checkUserExists(user_model.getLogin_type(), user_model.getAccess_token()); // logintype, token 으로 user 등록여부 확인
        User user = new User();

        if (user_model.getLogin_type() != null && user_model.getAccess_token() != null) {
            if (!exist) {
                user = userService.registUser(user_model); // 사용자 존재하지 않으면 등록.
            } else {
                user = userService.getUserByLoginInfo(user_model.getLogin_type(), user_model.getAccess_token()); //사용자 존재하면 사용자 데이터 가져오기.
            }
            message.put("user", user);
            message.put("status", true);
        } else {
            message.put("status", false);
        }
//        message.put("styleUser", styleUser);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }


    @PutMapping("/profile/{no}")
    public ResponseEntity profileEdit(@RequestBody User user, @PathVariable int no) {
        Message message = new Message();
        userService.editProfile(user, message);
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PutMapping("/profile/image/{no}")
    public ResponseEntity profileImageEdit(@RequestBody User user, @PathVariable int no) {
        Message message = new Message();
        userService.updateProfileImage(user.getProfile_img(), no);
        message.put("result", user.getProfile_img());
        message.put("status", true);
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
        if (address.getUser_no() == 0) {
            throw new ContentsException();
        } else {
            addressService.registAddress(address);
            message.put("status", true);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/address/{no}")
    public ResponseEntity editAddress(@RequestBody Address address, @PathVariable int no) {
        Message message = new Message();
        if (address.getNo() == 0) {
            throw new ContentsException();
        } else {
            addressService.updateAddress(address);
            message.put("status", true);
            message.put("address", address);
        }

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message), HttpStatus.OK);
    }

    @DeleteMapping("/address/{no}")
    public ResponseEntity deleteAddress(@PathVariable int no) {
        Message status = addressService.deleteAddress(no);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, status, true), HttpStatus.OK);
    }

    @GetMapping("/account/{user_no}")
    public ResponseEntity getAccountInfo(@PathVariable int user_no) {
        Message message = new Message();
        AccountInfo accountInfo = accountInfoService.getAccountInfo(user_no);
        message.put("accountInfo", accountInfo);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping("/account")
    public ResponseEntity registAccountInfo(@RequestBody AccountInfo accountInfo) {
        Message message = new Message();
        if (accountInfo == null || accountInfo.getUser_no() == 0) {
            throw new ContentsException();
        } else {
            accountInfoService.registAccountInfo(accountInfo);
            message.put("status", true);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PutMapping("/account/{user_no}")
    public ResponseEntity editAccountInfo(@RequestBody AccountInfo accountInfo, @PathVariable int user_no) {
        Message message = new Message();
        if (accountInfo == null || accountInfo.getUser_no() == 0) {
            throw new ContentsException();
        } else {
            accountInfoService.updateAccountInfo(accountInfo);
            message.put("status", true);
        }
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
        if (cardInfo == null || cardInfo.getNo() == 0) {
            throw new ContentsException();
        } else {
            cardInfoService.addCardInfo(cardInfo);
            message.put("status", true);
        }
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
        map.put("cr_card_number", user.getCr_card_number());
        map.put("cr_phone_number", user.getCr_phone_number());
        map.put("cr_alarm_agree", user.isCr_alarm_agree());

        message.put("receiptInfo", map);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/point/{no}")
    public ResponseEntity getPointList(@PathVariable int no) {
        Message message = new Message();

        Point point = pointService.getPointData(no);
        message.put("point", point);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @PostMapping("/point")
    public ResponseEntity RegistPoint(@RequestBody Point point) {
        Message message = new Message();
        if (point == null || point.getNo() == 0) {
            throw new ContentsException();
        } else {
            pointService.registPoint(point);
            message.put("status", true);
        }

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }


    @PostMapping("/file")
    public ResponseEntity uploadUserFile(@RequestBody MultipartFile file) {
        Message message = new Message();
        if (file.getSize() != 0) {
            log.info("file -> {},{},{}", file.getOriginalFilename(), file.getName(), file.getSize());
            MFile mFile = fileUploadUtility.uploadFile(file, CDNUploadPath.USER.getPath());
            message.put("file", mFile);
        }
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}

