package com.spring.Vodafone.exception.exceptions;


import org.springframework.http.HttpStatus;

public class ConflictException extends BaseException {

    public ConflictException(String message) {
        super(message);
    }
    @Override
    public HttpStatus getStatus() {
        return HttpStatus.CONFLICT;
    }
}