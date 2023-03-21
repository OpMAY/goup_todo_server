package com.exception;

import com.exception.enums.BaseExceptionType;
import lombok.Getter;

public class ContentsException extends RuntimeException{
    @Getter
    private BaseExceptionType exceptionType;

    public ContentsException(BaseExceptionType exceptionType){
        super(exceptionType.getErrorMessage());
        this.exceptionType = exceptionType;
    }

    public ContentsException(BaseExceptionType exceptionType, Exception e){
        super(exceptionType.getErrorMessage(),e.getCause());
        this.exceptionType = exceptionType;
    }

    public ContentsException( ) {

    }



}
