package com.controller;

import com.model.User;
import com.model.kream.cs.Notice;
import com.model.kream.cs.Qna;
import com.model.kream.home.Banner;
import com.model.kream.point.Point;
import com.model.kream.product.Product;
import com.model.kream.product.ProductAdmin;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import com.service.NoticeService;
import com.service.QnaService;
import com.service.kream.product.ProductService;
import com.service.kream.user.PointService;
import com.service.kream.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/admin")
public class AdminController {

    private final BannerService bannerService;
    private final UserService userService;
    private final PointService pointService;
    private final NoticeService noticeService;
    private final QnaService qnaService;

    private final ProductService productService;

    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public ModelAndView dashboard() {
        return new ModelAndView("admin/dashboard-4");
    }

    @RequestMapping(value = "/product/list", method = RequestMethod.GET)
    public ModelAndView products() {
        List<ProductAdmin> products = productService.getAdminProducts();
        ModelAndView VIEW = new ModelAndView("admin/product/product-list");
        VIEW.addObject("products", products);
        return VIEW;
    }

    @RequestMapping(value = "/product/detail/{no}", method = RequestMethod.GET)
    public ModelAndView productDetail(@PathVariable int no) {
        ProductAdmin productAdmin = productService.getAdminProduct(no);
        ModelAndView VIEW = new ModelAndView("admin/product/detail");
        VIEW.addObject("product", productAdmin);
        return VIEW;
    }

    @RequestMapping(value = "/banners", method = RequestMethod.GET)
    public ModelAndView getBanner(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/banner/banners");

        List<Banner> bannerList = bannerService.getAllBanner();
        view.addObject("bannerList", bannerList);
//
        message.put("bannerList",bannerList);
//
        return view;

    }

    @GetMapping("/user")
    public ModelAndView getUser(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<User> users = userService.getAllUser();
        view.addObject("users",users);

        return  view;
    }

    @GetMapping("/notice")
    public ModelAndView getNotice(@PathVariable int page){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<Notice> notices = noticeService.getNotices(page);
        view.addObject("notices",notices);

        return  view;
    }

    @GetMapping("/qna")
    public ModelAndView getNotice(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin");

        List<Qna> qnas = qnaService.getAllQna();
        view.addObject("qnas",qnas);

        return  view;
    }








}
