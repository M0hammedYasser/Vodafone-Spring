package com.spring.Vodafone.exception.exceptions;

import org.springframework.http.HttpStatus;

public class RecordNotFountException extends BaseException {

    public RecordNotFountException(String massage) {
        super(massage);
    }


    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
