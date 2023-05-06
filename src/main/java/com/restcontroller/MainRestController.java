package com.restcontroller;

import com.model.kream.home.Banner;
import com.model.kream.product.ProductMain;
import com.model.kream.product.brand.Brand;
import com.model.kream.product.brand.BrandMain;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import com.service.kream.product.BrandService;
import com.service.kream.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    private final BrandService brandService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public ResponseEntity getProductMain(HttpServletRequest request, @RequestParam(value = "user_no", required = false) Integer user_no) {
        Message message = new Message();
        List<Banner> banners = bannerService.getActiveBanners();
        List<ProductMain> popular_products = productService.getPopularProducts(user_no);
        List<ProductMain> recent_products = productService.getRecentProducts(user_no);
        List<BrandMain> brands = brandService.getMainBrands();
        message.put("popular_products", popular_products);
        message.put("recent_products", recent_products);
        message.put("banners", banners);
        message.put("brands", brands);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }
}
