package com.controller;

import com.api.LoginAPI;
import com.dao.AddressDao;
import com.dao.UserDao;
import com.exception.GrantAccessDeniedException;
import com.exception.enums.GlobalExceptionType;
import com.model.User;
import com.model.grant.GrantType;
import com.model.kream.user.address.Address;
import com.util.Constant;
import com.util.Encryption.EncryptionService;
import com.util.Encryption.JWTEnum;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {
    private final LoginAPI loginAPI;

    private final UserDao userDao;

    public static void main(String[] args) {
//        EncryptionService encryptionService = new EncryptionService();
//        System.out.println((encryptionService.encryptAES("jdbc:mysql://goup.cc5p1zh5h1ho.ap-northeast-2.rds.amazonaws.com:3306/goup", false)));

        String filter2 = "100000-300000";
        String filter3 = "3000000-";
        String filter = "-100000";
        String f = filter3;
        System.out.println(f.indexOf("-") + 1 == f.length());
        if (f.indexOf("-") == 0) {
            int min_price = 0;
            int max_price = Integer.parseInt(filter.substring(f.indexOf("-") + 1));
            System.out.println(min_price + " ~ " + max_price);
        } else {
            if (f.indexOf("-") + 1 == f.length()) {
                int min_price = Integer.parseInt(f.substring(0, f.indexOf("-")));
                System.out.println(min_price);
            } else {
                int min_price = Integer.parseInt(f.substring(0, f.indexOf("-")));
                int max_price = Integer.parseInt(f.substring(f.indexOf("-") + 1));
                System.out.println(min_price + " ~ " + max_price);
            }
        }
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home() {

        userDao.getProfileInfo(1);
        log.info("{}", userDao.getProfileInfo(1));
        return new ModelAndView("sample");
    }

    /**
     * Recover Interceptor Active
     */
    @RequestMapping(value = "/test/recover", method = RequestMethod.GET)
    public ModelAndView testRecover() {
        return new ModelAndView("error/recover");
    }

    @RequestMapping(value = "/test/error", method = RequestMethod.GET)
    public ModelAndView testError() {
        return new ModelAndView("error/error");
    }

    /**
     * Exception Error Test
     */
    @RequestMapping(value = "/test/exception", method = RequestMethod.GET)
    public ModelAndView testException() {
        if (true) {
            throw new GrantAccessDeniedException(GlobalExceptionType.GRANT_EXCEPTION);
        }
        return new ModelAndView("error/error");
    }

    /*
     * JWT Token Test
     * */
    private final EncryptionService encryptionService;

    @RequestMapping(value = "/test/jwt", method = RequestMethod.GET)
    public ModelAndView testJwt(HttpServletRequest request) {
        User user = new User();
        user.setEmail("zlzldntlr@naver.com");
        user.setName("김우식");
        user.setId("2034943");
        user.setGrant(GrantType.USER);
        user.setVersion(Constant.VERSION);
        user.setNo(324);
        request.getSession().setAttribute(JWTEnum.JWTToken.name(), encryptionService.encryptJWT(user));
        return new ModelAndView("sample");
    }

    /**
     * Test Websocket
     */
    @RequestMapping(value = "/test/websocket", method = RequestMethod.GET)
    public ModelAndView testWebsocket(HttpServletRequest request) {
        return new ModelAndView("test/websocket-test");
    }

    /**
     * Logic Test
     */
    @RequestMapping(value = "/test/logic", method = RequestMethod.GET)
    public ModelAndView test(HttpServletRequest request) {
        return new ModelAndView("test/login-test");
    }


}
