package com.sami.customer.customer.handeler;

import com.sami.customer.exception.CustomerNotFoundeException;
import org.apache.http.MethodNotSupportedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CustomerNotFoundeException.class)
    public ResponseEntity<String> handle(CustomerNotFoundeException exp ){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exp.getMsg());
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handle(MethodArgumentNotValidException exp ){
        var errors= new HashMap<String,String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var filedName=((FieldError)error).getField();
            var errorMessage=(error.getDefaultMessage());
            errors.put(filedName,errorMessage);
        });
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse(errors));
    }
}
