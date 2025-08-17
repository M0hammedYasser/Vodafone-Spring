package com.spring.Vodafone.exception.exceptions;

import org.springframework.http.HttpStatus;

public class EmployeeNotFoundException extends BaseException{

    public EmployeeNotFoundException(String massage) {
        super(massage);
    }

    @Override
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
