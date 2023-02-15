package com.service;

import com.api.bootpay.BootPayCancelModel;
import com.api.bootpay.BootPayDefaultModel;
import com.api.bootpay.BootpayApi;
import com.api.bootpay.v1.Cancel;
import com.api.bootpay.v1.VerifyResponse;
import com.api.bootpay.v2.VerifyResponseV2;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@RequiredArgsConstructor
public class BootPayService {
    private BootpayApi bootpayApi;

    @Value("${BOOTPAY.REST_API}")
    private String REST_API_KEY;

    @Value("${BOOTPAY.PRIVATE}")
    private String PRIVATE_KEY;


    @PostConstruct
    public void init() {
        try {
            log.info("bootPay Init : {}, {}", REST_API_KEY, PRIVATE_KEY);
            bootpayApi = new BootpayApi(REST_API_KEY, PRIVATE_KEY);
            bootpayApi.setToken(bootpayApi.getAccessToken());
            log.info("isTokenInit? : {}", bootpayApi.isTokenInit());
        } catch (Exception e) {
            e.printStackTrace();
            log.error("bootPay Init error : {}", e.getMessage());
        }
    }

    public boolean verifyReceipt(BootPayDefaultModel defaultModel) {
        try {
            Gson gson = new Gson();
            if(defaultModel.getMethod().equals("kakaopay")) {
                // KAKAO PAY의 경우 V1으로 검증해야함
                VerifyResponse response = gson.fromJson(verifyBootPayReceipt(defaultModel.getBootPayV1().getReceipt_id()), VerifyResponse.class);
                if(response.getData().getStatus() == 1 && response.getData().getPrice() == defaultModel.getBootPayV1().getPrice()) {
                    return true;
                } else {
                    VerifyResponse cancelResponse = gson.fromJson(cancelBootPayReceipt(defaultModel.getBootPayV1().getReceipt_id()), VerifyResponse.class);
                    if(cancelResponse.getData().getStatus() == 1) {
                        return false;
                    } else {
                        throw new Exception("BootPay 결제 취소 오류, receiptID : " + defaultModel.getBootPayV1().getReceipt_id());
                    }
                }
            } else {
                // 네이버페이, 카드 결제는 V2
                VerifyResponseV2 response = gson.fromJson(verifyBootPayReceipt(defaultModel.getBootPayV2().getReceipt_id()), VerifyResponseV2.class);
                if(response.getData().getStatus() == 1 && response.getData().getPrice() == defaultModel.getBootPayV2().getPrice()) {
                    return true;
                } else {
                    VerifyResponseV2 cancelResponse = gson.fromJson(cancelBootPayReceipt(defaultModel.getBootPayV2().getReceipt_id()), VerifyResponseV2.class);
                    if(cancelResponse.getData().getStatus() == 1) {
                        return false;
                    } else {
                        throw new Exception("BootPay 결제 취소 오류, receiptID : " + defaultModel.getBootPayV1().getReceipt_id());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("bootPay verifyReceipt Error : {}", e.getMessage());
            return false;
        }
    }

    public boolean cancelReceipt(BootPayCancelModel model)  {
        try {
            Gson gson = new Gson();
            if(model.getMethod().equals("kakaopay")) {
                VerifyResponse cancelResponse = gson.fromJson(cancelBootPayReceipt(model.getReceiptId()), VerifyResponse.class);
                if(cancelResponse.getData().getStatus() == 1) {
                    return false;
                } else {
                    throw new Exception("BootPay 결제 취소 오류, receiptID : " + model.getReceiptId());
                }
            } else {
                VerifyResponseV2 cancelResponse = gson.fromJson(cancelBootPayReceipt(model.getReceiptId()), VerifyResponseV2.class);
                if(cancelResponse.getData().getStatus() == 1) {
                    return false;
                } else {
                    throw new Exception("BootPay 결제 취소 오류, receiptID : " + model.getReceiptId());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("bootPay cancelReceipt Error : {}", e.getMessage());
            return false;
        }
    }

    /**
     * BootPay Receipt verify Function
     * ===============================
     * 해당 함수에서 영수증 ID 로 올바른 결제인지 검증하는 함수
     * BOOTPAY v1, BOOTPAY v2 의 객체가 모두 다르기에 Response를 String 형태로 받아서 각자 맞는 모델에 대입
     *
     * 만약 올바르지 않은 결제일 경우 바로 cancelReceipt 함수 실행할 것
     * **/
    private String verifyBootPayReceipt(String receiptId) throws Exception {
        HttpResponse res = bootpayApi.verify(receiptId);
        return getResponseToString(res);
    }

    private String cancelBootPayReceipt(String receiptId) throws Exception {
        HttpResponse response = bootpayApi.cancel(new Cancel(receiptId));
        return getResponseToString(response);
    }

    private String getResponseToString(HttpResponse res) throws IOException {
        return IOUtils.toString(res.getEntity().getContent(), StandardCharsets.UTF_8);
    }


}
