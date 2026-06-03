package com.rahulscripts.departmentcategorizer.advices;

import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

public class ApiResponse<T> {
    T data;
    ApiError error;
    LocalDateTime timeStamp;

    ApiResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    ApiResponse(T data){
        this();
        this.data = data;
    }

    ApiResponse(ApiError error){
        this.error = error;
    }
}
