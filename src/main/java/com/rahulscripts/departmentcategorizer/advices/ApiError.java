package com.rahulscripts.departmentcategorizer.advices;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
public class ApiError {
    HttpStatus status;
    String error;
    List<String> subErrors;
}
