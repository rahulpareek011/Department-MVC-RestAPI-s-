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

    ApiResponse(T data){
        this();
        this.data = data;
    }

    ApiResponse(ApiError error){
        this.error = error;
    }
}
