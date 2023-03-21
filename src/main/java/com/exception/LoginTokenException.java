package com.exception;

import com.exception.enums.BaseExceptionType;
import lombok.Getter;

public class LoginTokenException extends RuntimeException{
    @Getter
    private BaseExceptionType exceptionType;

    public LoginTokenException() {

    }

    public LoginTokenException(String message){
        super(message);
    }



    public LoginTokenException(BaseExceptionType exceptionType) {
        super(exceptionType.getErrorMessage());
        this.exceptionType = exceptionType;
    }

    public LoginTokenException(BaseExceptionType exceptionType, Exception e) {
        super(exceptionType.getErrorMessage(), e.getCause());
        this.exceptionType = exceptionType;
    }




}
