package com.hori.instagram_clone_api.global.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.hori.instagram_clone_api.global.response.ErrorResponse;
import com.hori.instagram_clone_api.user.exception.CreateUserException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<ErrorResponse> notFoundHandler(RuntimeException ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), null,ex.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
        
    }

    @ExceptionHandler({CreateUserException.class})
    protected ResponseEntity<ErrorResponse> createUserErrorHandler(CreateUserException ex){
        
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(),ex.getErrors(), ex.getMessage());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        
    }


}
