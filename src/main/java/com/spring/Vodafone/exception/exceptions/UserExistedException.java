package com.spring.Vodafone.exception.exceptions;

import org.springframework.http.HttpStatus;

public class UserExistedException extends BaseException {
    public UserExistedException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.FOUND;
    }
}
