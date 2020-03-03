package com.internship.ds.exceptionAOP.advice;

import com.internship.ds.exceptionAOP.exception.ZcException;
import com.internship.ds.exceptionAOP.vo.ExceptionResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {

    @ExceptionHandler(ZcException.class)
    public ResponseEntity<ExceptionResult> handleException(ZcException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionResult(e.getExceptionEnums()));
    }
}
