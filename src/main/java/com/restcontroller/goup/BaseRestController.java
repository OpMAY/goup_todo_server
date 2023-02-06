package com.restcontroller.goup;

import com.response.DefaultRes;
import com.response.Message;
import com.util.Encryption.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class BaseRestController {
    @Value("${GOUP.ACCESS.KEY}")
    private String accessKey;

    private final EncryptionService encryptionService;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResponseEntity getAuth(HttpServletRequest request, @RequestParam("key") String key) {
        Message message = new Message();
        if(key.equals(accessKey)) {
            message.put("key", encryptionService.encryptGoupJWT());
            return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
        } else {
            return new ResponseEntity(DefaultRes.res(HttpStatus.BAD_REQUEST), HttpStatus.OK);
        }
    }
}
