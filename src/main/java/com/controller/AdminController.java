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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        VIEW.addObject("brands", productService.getBrands());
        VIEW.addObject("categories", productService.getCategories());
        return VIEW;
    }

    @RequestMapping(value = "/product/brands", method = RequestMethod.GET)
    public ModelAndView brands() {
        ModelAndView VIEW = new ModelAndView("admin/product/brand-list");
        VIEW.addObject("brands", productService.getBrands());
        return VIEW;
    }

    @RequestMapping(value = "/product/categories", method = RequestMethod.GET)
    public ModelAndView categories() {
        ModelAndView VIEW = new ModelAndView("admin/product/category-list");
        VIEW.addObject("categories", productService.getCategories());
        return VIEW;
    }

    @RequestMapping(value = "/banner/list", method = RequestMethod.GET)
    public ModelAndView getBanner(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/banner/banner-list");

        List<Banner> banner = bannerService.getAllBanner();
        view.addObject("banner", banner);
//
        message.put("banner",banner);
//
        return view;

    }

    @RequestMapping(value = "/banner-detail/{no}", method = RequestMethod.GET)
    public ModelAndView getDetailBanner(@PathVariable int no){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/banner/detail");

        Banner banner = bannerService.getBanner(no);
        view.addObject("banner", banner);
//
        message.put("banner",banner);
//
        return view;

    }

    @RequestMapping(value = "/banner/add", method = RequestMethod.GET)
    public ModelAndView addBanner(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/banner/add");

        return view;

    }

    @GetMapping("/user/list")
    public ModelAndView getUser(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/user/user-list");

        List<User> user = userService.getAllUser();
        view.addObject("user",user);

        return  view;
    }

    @RequestMapping(value = "/user-detail/{no}", method = RequestMethod.GET)
    public ModelAndView getDetailUser(@PathVariable int no){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/user/detail");

        User user = userService.getProfileInfo(no);
        view.addObject("user", user);
//
        message.put("user",user);
//
        return view;

    }

    @RequestMapping(value = "/user/add", method = RequestMethod.GET)
    public ModelAndView addUser(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/user/add");
        return view;
    }


    @GetMapping("/notice/list")
    public ModelAndView getNotice(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin/notice/notice-list");
        List<Notice> notice = noticeService.getAllnotice();
        view.addObject("notice",notice);
        message.put("notice",notice);
        return  view;
    }

    @GetMapping("/qna/list")
    public ModelAndView getQna(){
        Message message = new Message();
        ModelAndView view = new ModelAndView("/admin/qna/qna-list");
        List<Qna> qna = qnaService.getAllQna();
        view.addObject("qna",qna);
        return  view;
    }

    @RequestMapping(value = "/qna-detail/{no}", method = RequestMethod.GET)
    public ModelAndView QnADetail(@PathVariable int no){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/qna/detail");
        Qna qna = qnaService.getQnaData(no);
        view.addObject("qna", qna);
        message.put("qna",qna);
        return view;

    }

    @RequestMapping(value = "/notice-detail/{no}", method = RequestMethod.GET)
    public ModelAndView NoticeDetail(@PathVariable int no){
        Message message = new Message();
        ModelAndView view = new ModelAndView("admin/notice/detail");
        Notice notice = noticeService.getNotice(no);
        view.addObject("notice", notice);
        message.put("notice",notice);
        return view;

    }
}
