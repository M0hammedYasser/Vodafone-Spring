package com.spring.Vodafone.exception.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = BaseException.class)
    public ResponseEntity<?> exceptionHandler(BaseException e) {
        return ResponseEntity.status(e.getStatus()).body(e.getMessage());
    }
}
