package com.restcontroller;

import com.model.kream.home.Banner;
import com.model.kream.product.ProductMain;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import com.service.kream.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/kream/")
public class MainRestController {
    private final ProductService productService;
    private final BannerService bannerService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity getProductMain(HttpServletRequest request) {
        Message message = new Message();
        // TODO Type 별 products => Main Controller 로 빠질 예정
        List<Banner> banners = bannerService.getAllBanner();
        List<ProductMain> popular_products = productService.getPopularProducts(0);
        List<ProductMain> recent_products = productService.getRecentProducts(0);
        message.put("popular_products", popular_products);
        message.put("recent_products", recent_products);
        message.put("banners", banners);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
