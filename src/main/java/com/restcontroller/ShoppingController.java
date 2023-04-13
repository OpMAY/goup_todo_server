package com.restcontroller;


import com.model.kream.order.ORDER_STATUS;
import com.model.kream.order.after.sub.INSPECTION_TYPE;
import com.model.kream.order.after.sub.SELLSTOCK_TYPE;
import com.model.kream.order.before.Purchase;
import com.model.kream.order.before.Sell;
import com.model.kream.order.before.sub.sell.SELL_TYPE;
import com.model.kream.product.interactions.WishList;
import com.response.DefaultRes;
import com.response.Message;
import com.service.kream.shop.PurchaseService.PurchaseService;
import com.service.kream.shop.SellService;
import com.service.kream.shop.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.List;

import static java.time.LocalTime.now;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream/my")
public class ShoppingController {

    private final WishService wishService;

    private final SellService sellService;

    private final PurchaseService purchaseService;

    @GetMapping("/wish/{user_no}")
    public ResponseEntity getWishList(HttpServletRequest request, HttpServletResponse response,
                                      @PathVariable int user_no) {
        Message message = new Message();
        List<WishList> wish = wishService.getMywishList(user_no);
        System.out.println("WISH " + wish);
        message.put("status",true);
        message.put("wish",wish);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/sell/{user_no}") // 판매내역-판매입찰
    public ResponseEntity getSell(HttpServletRequest request, HttpServletResponse response,
                              @PathVariable int user_no,
                              @RequestParam (value="expiration_date" ,required = false) String expiration_date
                              ) {
        Message message = new Message();
        LocalDate exdate = LocalDate.parse(expiration_date);
        List<Sell>  sellList = sellService.getMySell(user_no,exdate);

        message.put("sell",sellList);
        message.put("COUNT!!!!!!" , sellList.size());


        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/selling/{user_no}") // 판매내역-진행중
    public ResponseEntity getSelling(HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable int user_no,
                                     @RequestParam(value="status",required = false) SELLSTOCK_TYPE status,
                                     @RequestParam(value="type",required = false) INSPECTION_TYPE type,
                                     @RequestParam(value="order_status",required = false) ORDER_STATUS order_status) {
        Message message = new Message();
        List<Sell> sellList =sellService.getMySellByOrder(user_no,status,type,order_status);
        message.put("판매중",sellList);




        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    @GetMapping("/sellcom/{user_no}") // 판매내역-종료
    public ResponseEntity getCompleteSell(HttpServletRequest request, HttpServletResponse response,
                                          @PathVariable int user_no,
                                          @RequestParam(value = "sell_type",required = false)SELL_TYPE sell_type
                                          ) {
        Message message = new Message();
        List<Sell> sellList =sellService.getMySellNotByOrder(user_no,sell_type);
        message.put("판매중",sellList);




        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }


    @GetMapping("/purchase/{user_no}") // 판매내역-판매입찰
    public ResponseEntity getPurchase(HttpServletRequest request, HttpServletResponse response,
                                  @PathVariable int user_no,
                                  @RequestParam (value="expiration_date" ,required = false) String expiration_date
    ) {
        Message message = new Message();
        LocalDate exdate = LocalDate.parse(expiration_date);
        List<Purchase> purchaseList = purchaseService.getMyPurchase(user_no,exdate);


        message.put("purchaseList",purchaseList);
        message.put("COUNT!!!!!!" , purchaseList.size());


        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);

    }

    
}
