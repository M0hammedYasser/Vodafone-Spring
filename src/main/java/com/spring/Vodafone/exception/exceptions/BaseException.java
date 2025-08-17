package com.spring.Vodafone.exception.exceptions;

import org.springframework.http.HttpStatus;

public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

    public abstract HttpStatus getStatus();
}
