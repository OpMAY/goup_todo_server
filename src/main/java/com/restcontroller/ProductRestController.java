package com.restcontroller;

import com.model.kream.product.ProductMain;
import com.model.kream.product.ProductShop;
import com.response.DefaultRes;
import com.response.Message;
import com.service.kream.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity getProductMain(HttpServletRequest request) {
        Message message = new Message();
        List<ProductMain> products = productService.getMainProducts(0);
        message.put("products", products);
        message.put("last_idx", products.size() > 0 ? products.get(products.size() - 1).getNo() : 0);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @RequestMapping(value = "/shop", method = RequestMethod.GET)
    public ResponseEntity getProductShop(HttpServletRequest request) {
        Message message = new Message();
        List<ProductShop> products = productService.getShopProducts(0);
        message.put("products", products);
        message.put("last_idx", products.size() > 0 ? products.get(products.size() - 1).getNo() : 0);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
