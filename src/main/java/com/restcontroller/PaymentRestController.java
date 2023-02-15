package com.restcontroller;

import com.api.bootpay.BootPayCancelModel;
import com.api.bootpay.BootPayDefaultModel;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BootPayService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/bootpay")
public class PaymentRestController {
    private final BootPayService bootPayService;

    @Value("${BOOTPAY.API}")
    private String BOOTPAY_JAVASCRIPT;

    @RequestMapping(value = "/key", method = RequestMethod.GET)
    public ResponseEntity getBootPayKey() {
        Message message = new Message();
        message.put("key", BOOTPAY_JAVASCRIPT);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/verify", method = RequestMethod.POST)
    public ResponseEntity verifyBootPayReceipt(@RequestBody BootPayDefaultModel model) {
        Message message = new Message();
        message.put("status", bootPayService.verifyReceipt(model));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public ResponseEntity cancelBootPayReceipt(@RequestBody BootPayCancelModel model) {
        Message message = new Message();
        message.put("status", bootPayService.cancelReceipt(model));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
