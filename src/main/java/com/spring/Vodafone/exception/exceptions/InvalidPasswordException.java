package com.spring.Vodafone.exception.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends BaseException {

    public InvalidPasswordException(String massage) {
        super(massage);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
