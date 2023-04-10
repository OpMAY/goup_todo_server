package com.restcontroller;

import com.aws.file.FileUploadUtility;
import com.aws.model.CDNUploadPath;
import com.exception.ContentsException;
import com.model.User;
import com.model.common.MFile;
import com.model.kream.cs.Notice;
import com.model.kream.home.Banner;
import com.model.kream.point.Point;
import com.model.kream.product.brand.Brand;
import com.model.kream.user.style.StyleUser;
import com.response.DefaultRes;
import com.response.Message;
import com.service.BannerService;
import com.service.kream.product.BrandService;
import com.service.kream.product.CategoryService;
import com.service.kream.user.PointService;
import com.service.kream.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/kream/admin")
public class AdminRestController {

    private final BannerService bannerService;
    private final UserService userService;
    private final PointService pointService;
    private final FileUploadUtility fileUploadUtility;
    private final BrandService brandService;

    private final CategoryService categoryService;


    @PostMapping(value = "/banner")
    public ResponseEntity registBanner(@RequestBody Banner banner) {
        Message message = new Message();
        log.info("{}", banner);

        bannerService.registBanner(banner);
        message.put("status", true);


        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping(value = "/banner/file/{no}")
    public ResponseEntity editBanner(@RequestBody MultipartFile file, @PathVariable int no) {
        Message message = new Message();
        if (bannerService.getBanner(no) == null) {
            throw new ContentsException();
        } else {
            if (file.getSize() != 0) {
                log.info("file -> {},{},{}", file.getOriginalFilename(), file.getName(), file.getSize());
                MFile mFile = fileUploadUtility.uploadFile(file, CDNUploadPath.BANNER.getPath());
                message.put("file", mFile);
            }
            message.put("status", true);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PutMapping(value = "/banner/{no}")
    public ResponseEntity editBanner(@RequestBody Banner banner, @PathVariable int no) {
        Message message = new Message();
        if (bannerService.getBanner(no) == null) {
            throw new ContentsException();
        } else {
            banner.setNo(no);
            log.info("banner : {}", banner);
            bannerService.editBanner(banner);
            message.put("status", true);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/banner/{no}")
    public ResponseEntity getBannerDetail(@PathVariable int no) {
        Message message = new Message();
        log.info("{}", bannerService.getBanner(no));
        message.put("banner", bannerService.getBanner(no));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }


    @DeleteMapping("/banner/{no}")
    public ResponseEntity deleteBanner(@PathVariable int no) {
        Message message = new Message();

        bannerService.deleteBanner(no);
        message.put("status", true);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping("/brand")
    public ResponseEntity makeBrand(@RequestBody Brand brand) {
        Message message = new Message();
        Brand result = brandService.makeBrand(brand);
        message.put("status", result != null);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PutMapping("/brand/{no}")
    public ResponseEntity updateBrand(@PathVariable int no, @RequestBody Brand brand) {
        Message message = new Message();
        brand.setNo(no);
        message.put("status", brandService.updateBrand(brand));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @DeleteMapping("/brand/{no}")
    public ResponseEntity deleteBrand(@PathVariable int no) {
        Message message = new Message();
        message.put("status", brandService.deleteBrand(no));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/category/children/{no}")
    public ResponseEntity getCategoryChildren(@PathVariable int no) {
        Message message = new Message();
        message.put("categories", categoryService.getCategoryChildren(no));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping(value = "/user")
    public ResponseEntity registUser(@RequestBody User user) {
        Message message = new Message();
        log.info("{}", user);
        userService.registUser(user, new StyleUser());
        message.put("status", true);
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping(value = "/user/file/{no}")
    public ResponseEntity editProfileImage(@RequestBody MultipartFile file, @PathVariable int no) {
        Message message = new Message();
        if (userService.getProfileInfo(no) == null) {
            throw new ContentsException();
        } else {
            if (file.getSize() != 0) {
                log.info("file -> {},{},{}", file.getOriginalFilename(), file.getName(), file.getSize());
                MFile mFile = fileUploadUtility.uploadFile(file, CDNUploadPath.USER.getPath());
                message.put("file", mFile);
            }
            message.put("status", true);
        }
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PostMapping(value = "/user/file")
    public ResponseEntity addProfileImage(@RequestBody MultipartFile file) {
        Message message = new Message();
        if (file.getSize() != 0) {
            log.info("file -> {},{},{}", file.getOriginalFilename(), file.getName(), file.getSize());
            MFile mFile = fileUploadUtility.uploadFile(file, CDNUploadPath.USER.getPath());
            message.put("file", mFile);
        }
        message.put("status", true);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @GetMapping("/user/{no}")
    public ResponseEntity getUserDetail(@PathVariable int no) {
        Message message = new Message();
        message.put("user", userService.getProfileInfo(no));
        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }


    @PutMapping("/user/suspended/{no}")
    public ResponseEntity userSuspended(@PathVariable int no) {
        Message message = new Message();

        userService.userSuspended(no, 0);
        message.put("status", true);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PutMapping("/user/point/{no}")
    public ResponseEntity givePoint(@PathVariable int no, @RequestParam int point) {
        Message message = new Message();
        Point pointData = pointService.getPointData(no);
        pointService.editPoint(pointData.getUser_no(), pointData.getPoint() + point);


        message.put("status", true);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }

    @PutMapping("/user/{no}")
    public ResponseEntity userEdit(@PathVariable int no, @RequestBody User user) {
        Message message = new Message();
        log.info("{}", user);

        userService.editUser(user);

        message.put("status", true);

        return new ResponseEntity(DefaultRes.res(HttpStatus.OK, message, true), HttpStatus.OK);
    }


}
