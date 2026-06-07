package com.rahulscripts.departmentcategorizer.advices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<?>> handleException(NoSuchElementException e){
        ApiError apiError = ApiError.builder().
                status(HttpStatus.NOT_FOUND).
                error(e.getMessage()).
                build();
        return new ResponseEntity<>(new ApiResponse<>(apiError),apiError.getStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<?>> handleException(Exception exception){
        ApiError apiError = ApiError.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .error(exception.getMessage())
                .build();
        return new ResponseEntity<>(new ApiResponse<>(apiError),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
