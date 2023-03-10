package com.exception;

import com.exception.enums.BaseExceptionType;
import lombok.Getter;

public class HeaderAuthorizationTokenException extends RuntimeException {
    @Getter
    private BaseExceptionType exceptionType;

    public HeaderAuthorizationTokenException(BaseExceptionType exceptionType) {
        super(exceptionType.getErrorMessage());
        this.exceptionType = exceptionType;
    }

    public HeaderAuthorizationTokenException(BaseExceptionType exceptionType, Exception e) {
        super(exceptionType.getErrorMessage(), e.getCause());
        this.exceptionType = exceptionType;
    }
}
