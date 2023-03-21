package com.interceptor;

import com.exception.HeaderAuthorizationTokenException;
import com.exception.enums.BaseExceptionType;
import com.exception.enums.GlobalExceptionType;
import com.util.Encryption.EncryptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component
public class RestInterceptor extends HandlerInterceptorAdapter {
    @Value("${GOUP.ACCESS.KEY}")
    private String accessKey;
    private final EncryptionService encryptionService;

    @PostConstruct
    public void RestInterceptor(){
        log.debug("Rest Interceptor Post Init");
        log.debug("Goup Access Key : {}", accessKey);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String authorization = request.getHeader("Authorization");
//        if(authorization != null && authorization.contains("bearer ")) {
//            String token = authorization.substring(authorization.indexOf("bearer") + "bearer".length() + 1);
//            if(encryptionService.decryptGoupJWT(token)) {
//                return true;
//            } else {
//                throw new HeaderAuthorizationTokenException(GlobalExceptionType.TOKEN_EXCEPTION);
//            }
//        } else {
//            throw new HeaderAuthorizationTokenException(GlobalExceptionType.TOKEN_EXCEPTION);
//        }
        return true;
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
