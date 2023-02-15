package com.api.bootpay;

import com.google.gson.Gson;
import com.api.bootpay.v1.*;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class BootpayApi {
    private final String BASE_URL = "https://api.bootpay.co.kr/";
    private final String URL_ACCESS_TOKEN = BASE_URL + "request/token.json";
    private final String URL_VERIFY = BASE_URL + "receipt";

    /**
     * CANCEL URL V2로 변경 => V2의 취소 response 가 더 명확한 데이터를 불러옴
     * **/
    private final String URL_CANCEL = BASE_URL + "v2/cancel";

    private final String URL_GET_SUBSCRIBE_BILLING_KEY = BASE_URL + "request/card_rebill.json";
    private final String URL_DESTROY_SUBSCRIBE_BILLING_KEY = BASE_URL + "subscribe/billing/";
    private final String URL_SUBSCRIBE_BILLING = BASE_URL + "subscribe/billing.json";
    private final String URL_SUBSCRIBE_BILLING_RESERVE = BASE_URL + "subscribe/billing/reserve.json";
    private final String URL_SUBSCRIBE_BILLING_RESERVE_CANCEL = BASE_URL + "subscribe/billing/reserve/";
    private final String URL_GET_USER_TOKEN = BASE_URL + "request/user/token";
    private final String URL_PAYMENT_LINK = BASE_URL + "request/payment";
    private final String URL_CERTIFICATE = BASE_URL + "certificate/";

//     private final String URL_SEND_SMS = BASE_URL + "push/sms.json";
//     private final String URL_SEND_LMS = BASE_URL + "push/lms.json";

//    private final String URL_NAVERPAY_ITEM_RESPONSE = BASE_URL + "npay/product.json";
//     private final String URL_REMOTE_FORM = BASE_URL + "app/rest/remote_form.json";

    private String token;
    private String application_id;
    private String private_key;

    public BootpayApi() {
    }

    public BootpayApi(String rest_application_id, String private_key) {
        this.application_id = rest_application_id;
        this.private_key = private_key;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isTokenInit() {
        return this.token != null;
    }

    private HttpGet getGet(String url) throws Exception {
        HttpGet get = new HttpGet(url);
        URI uri = new URIBuilder(get.getURI()).build();
        get.setURI(uri);
        return get;
    }

    private HttpGet getGet(String url, List<NameValuePair> nameValuePairList) throws Exception {
        HttpGet get = new HttpGet(url);
        get.setHeader("Accept", "application/json");
        get.setHeader("Content-Type", "application/json");
        get.setHeader("Accept-Charset", "utf-8");
        URI uri = new URIBuilder(get.getURI()).addParameters(nameValuePairList).build();
        get.setURI(uri);
        return get;
    }

    private HttpPost getPost(String url, StringEntity entity) {
        HttpPost post = new HttpPost(url);
        post.setHeader("Accept", "application/json");
        post.setHeader("Content-Type", "application/json");
        post.setHeader("Accept-Charset", "utf-8");
        post.setEntity(entity);
        return post;
    }

    private HttpDelete getDelete(String url) {
        HttpDelete delete = new HttpDelete(url);
        delete.setHeader("Accept", "application/json");
        delete.setHeader("Content-Type", "application/json");
        delete.setHeader("Accept-Charset", "utf-8");
        return delete;
    }

    public String getAccessToken() throws Exception {
        if (this.application_id == null || this.application_id.isEmpty())
            throw new Exception("application_id 값이 비어있습니다.");
        if (this.private_key == null || this.private_key.isEmpty()) throw new Exception("private_key 값이 비어있습니다.");

        Token token = new Token();
        token.application_id = this.application_id;
        token.private_key = this.private_key;

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_ACCESS_TOKEN, new StringEntity(new Gson().toJson(token), StandardCharsets.UTF_8));

        HttpResponse res = client.execute(post);
        String str = IOUtils.toString(res.getEntity().getContent(), StandardCharsets.UTF_8);
        ResToken resToken = new Gson().fromJson(str, ResToken.class);

        if (resToken.status == 200) {
            this.token = resToken.data.token;
            return this.token;
        } else {
            return null;
        }
    }

    public HttpResponse verify(String receipt_id) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = getGet(URL_VERIFY + "/" + receipt_id + ".json");
        get.setHeader("Authorization", this.token);
        return client.execute(get);
    }

    public HttpResponse cancel(Cancel cancel) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_CANCEL, new StringEntity(new Gson().toJson(cancel), "UTF-8"));
        post.setHeader("Authorization", "Bearer " + this.token);
        return client.execute(post);
    }

    public HttpResponse get_subscribe_billing_key(SubscribeBilling subscribeBilling) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
//         if(subscribeBilling.billing_key == null || subscribeBilling.billing_key.isEmpty()) throw new Exception("billing_key 값을 입력해주세요.");
        if (subscribeBilling.item_name == null || subscribeBilling.item_name.isEmpty())
            throw new Exception("item_name 값을 입력해주세요.");
        if (subscribeBilling.order_id == null || subscribeBilling.order_id.isEmpty())
            throw new Exception("order_id 주문번호를 설정해주세요.");
        if (subscribeBilling.pg == null || subscribeBilling.pg.isEmpty())
            throw new Exception("결제하고자 하는 pg alias를 입력해주세요.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_GET_SUBSCRIBE_BILLING_KEY, new StringEntity(new Gson().toJson(subscribeBilling), "UTF-8"));
        post.setHeader("Authorization", this.token);
        return client.execute(post);
    }

    public HttpResponse destroy_subscribe_billing_key(String billing_key) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
        if (billing_key == null || billing_key.isEmpty()) throw new Exception("billing_key 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete delete = getDelete(URL_DESTROY_SUBSCRIBE_BILLING_KEY + billing_key + ".json");
        delete.setHeader("Authorization", this.token);
        return client.execute(delete);
    }

    public HttpResponse subscribe_billing(SubscribeBilling subscribeBilling) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
        if (subscribeBilling.billing_key == null || subscribeBilling.billing_key.isEmpty())
            throw new Exception("billing_key 값을 입력해주세요.");
        if (subscribeBilling.item_name == null || subscribeBilling.item_name.isEmpty())
            throw new Exception("item_name 값을 입력해주세요.");
//        if(subscribeBilling.price <= 0) throw new Exception("price 금액을 설정을 해주세요.");
        if (subscribeBilling.order_id == null || subscribeBilling.order_id.isEmpty())
            throw new Exception("order_id 주문번호를 설정해주세요.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_SUBSCRIBE_BILLING, new StringEntity(new Gson().toJson(subscribeBilling), "UTF-8"));
        post.setHeader("Authorization", this.token);
        return client.execute(post);
    }

    public HttpResponse subscribe_reserve_billing(SubscribeBillingReserve subscribeBillingReserve) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
        if (subscribeBillingReserve.billing_key == null || subscribeBillingReserve.billing_key.isEmpty())
            throw new Exception("billing_key 값을 입력해주세요.");
        if (subscribeBillingReserve.item_name == null || subscribeBillingReserve.item_name.isEmpty())
            throw new Exception("item_name 값을 입력해주세요.");

        if (subscribeBillingReserve.order_id == null || subscribeBillingReserve.order_id.isEmpty())
            throw new Exception("order_id 주문번호를 설정해주세요.");
        if (subscribeBillingReserve.execute_at == 0) throw new Exception("execute_at 실행 시간을 설정해주세요.");
        if (subscribeBillingReserve.scheduler_type == null || subscribeBillingReserve.scheduler_type.isEmpty())
            subscribeBillingReserve.scheduler_type = "oneshot";

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_SUBSCRIBE_BILLING_RESERVE, new StringEntity(new Gson().toJson(subscribeBillingReserve), "UTF-8"));
        post.setHeader("Authorization", this.token);
        return client.execute(post);
    }

    public HttpResponse subscribe_reserve_cancel(String reserve_id) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
        if (reserve_id == null || reserve_id.isEmpty()) throw new Exception("reserve_id 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpDelete delete = getDelete(URL_SUBSCRIBE_BILLING_RESERVE_CANCEL + reserve_id + ".json");
        delete.setHeader("Authorization", this.token);
        return client.execute(delete);
    }

    public HttpResponse getUserToken(BootpayUser bootpayUser) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
        if (bootpayUser == null) throw new Exception("user 개체가 비어있습니다.");
        if (bootpayUser.user_id == null || bootpayUser.user_id.isEmpty()) throw new Exception("user_id 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_GET_USER_TOKEN, new StringEntity(new Gson().toJson(bootpayUser), "UTF-8"));
        post.setHeader("Authorization", this.token);
        return client.execute(post);
    }

    public HttpResponse requestPayment(RequestLink requestPayment) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = getPost(URL_PAYMENT_LINK, new StringEntity(new Gson().toJson(requestPayment), "UTF-8"));
        post.setHeader("Authorization", this.token);
        return client.execute(post);
    }

    public HttpResponse certificate(String receipt_id) throws Exception {
        if (this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = getGet(URL_CERTIFICATE + "/" + receipt_id + ".json");
        get.setHeader("Authorization", this.token);
        return client.execute(get);
    }

    /*
     public HttpResponse remote_form(RemoteForm remoteForm) throws Exception {
         if(this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");

         HttpClient client = HttpClientBuilder.create().build();
         HttpPost post = getPost(URL_REMOTE_FORM, new StringEntity(new Gson().toJson(remoteForm), "UTF-8"));
         post.setHeader("Authorization", this.token);
         return client.execute(post);
     }

     public HttpResponse send_sms(SMS sms) throws Exception {
         if(this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
         if(sms.sp == null || sms.sp.isEmpty()) throw new Exception("sp 보내는 사람의 전화번호 값이 비어있습니다.");
         if(sms.rps == null || sms.rps.size() == 0) throw new Exception("rps 받는 사람의 전화번호 값이 비어있습니다.");
         if(sms.msg == null || sms.msg.isEmpty()) throw new Exception("msg 문자 내용 값이 비어있습니다.");

         HttpClient client = HttpClientBuilder.create().build();
         HttpPost post = getPost(URL_SEND_SMS, new StringEntity(new Gson().toJson(sms), "UTF-8"));
         post.setHeader("Authorization", this.token);
         return client.execute(post);
     }

     public HttpResponse send_lms(LMS lms) throws Exception {
         if(this.token == null || this.token.isEmpty()) throw new Exception("token 값이 비어있습니다.");
         if(lms.sp == null || lms.sp.isEmpty()) throw new Exception("sp 보내는 사람의 전화번호 값이 비어있습니다.");
         if(lms.rps == null || lms.rps.size() == 0) throw new Exception("rps 받는 사람의 전화번호 값이 비어있습니다.");
         if(lms.msg == null || lms.msg.isEmpty()) throw new Exception("msg 문자 내용 값이 비어있습니다.");
         if(lms.sj == null || lms.sj.isEmpty()) throw new Exception("sj 제목 값이 비어있습니다.");

         HttpClient client = HttpClientBuilder.create().build();
         HttpPost post = getPost(URL_SEND_LMS, new StringEntity(new Gson().toJson(lms), "UTF-8"));
         post.setHeader("Authorization", this.token);
         return client.execute(post);
     }
     */
}
