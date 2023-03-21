package com.interceptor;

import com.exception.LoginTokenException;
import com.exception.enums.BaseExceptionType;
import com.model.User;
import com.service.kream.user.UserService;
import com.util.Encryption.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@RequiredArgsConstructor
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private final EncryptionService encryptionService;

    private final UserService userService;
    private BaseExceptionType exceptionType;

    public void LoginInterceptor(){
        log.debug("LogIn Interceptor");
    }



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        String access_token = (String) session.getAttribute("access_token");
        User user = userService.getUserbyToken(access_token);

        if(access_token != null && session !=null   ){
            if(user.getUser_flag()==1) {
                return true;
            }else {
                throw new LoginTokenException("삭제된 사용자 입니다.");
            }
        }else{
            throw new LoginTokenException();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);
    }
}
