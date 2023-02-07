package com.restcontroller.goup;

import com.dao.TaskDao;
import com.response.DefaultRes;
import com.response.Message;
import com.util.Encryption.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "http://localhost:3000", allowedHeaders = "*")
@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api")
public class BaseRestController {
    @Value("${GOUP.ACCESS.KEY}")
    private String accessKey;

    private final EncryptionService encryptionService;
    private final TaskDao taskDao;

    @RequestMapping(value = "/auth", method = RequestMethod.GET)
    public ResponseEntity getAuth(HttpServletRequest request, @RequestParam("key") String key) {
        Message message = new Message();
        log.info("accessKey : {}", accessKey);
        if (key.equals(encryptionService.encryptAES(accessKey, true))) {
            message.put("key", encryptionService.encryptGoupJWT());
            return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
        } else {
            return new ResponseEntity(DefaultRes.res(HttpStatus.BAD_REQUEST), HttpStatus.OK);
        }
    }

    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public ResponseEntity getToken(HttpServletRequest request, @RequestParam("key") String key) {
        Message message = new Message();
        String result = encryptionService.encryptAES(key, true);
        if (taskDao.checkUserExists(result)) {
            message.put("status", false);
        } else {
            message.put("status", true);
            message.put("token", result);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
