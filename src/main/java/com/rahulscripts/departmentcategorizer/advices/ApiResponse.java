package com.rahulscripts.departmentcategorizer.advices;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse<T> {
    T data;
    ApiError error;
    LocalDateTime timeStamp;

    ApiResponse(){
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data){
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error){
        this.error = error;
    }
}
