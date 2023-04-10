package com.restcontroller;


import com.model.User;
import com.model.kream.product.interactions.Wish;
import com.model.kream.product.interactions.WishList;
import com.response.DefaultRes;
import com.response.Message;
import com.service.kream.shop.WishService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream/shoppingInfo")
public class ShoppingController {

    private final WishService wishService;

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
}
