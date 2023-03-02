package com.restcontroller;

import com.response.DefaultRes;
import com.response.Message;
import com.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(value = "/api/kream/product")
public class ProductRestController {
    private final ProductService productService;

    @RequestMapping(value = "/detail/{no}", method = RequestMethod.GET)
    public ResponseEntity getProductDetail(@PathVariable int no) {
        Message message = new Message();
        message.put("product", productService.getProductDetail(no));
        productService.updateProductViews(no);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
