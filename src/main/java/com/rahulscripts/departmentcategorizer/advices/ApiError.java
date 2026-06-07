package com.rahulscripts.departmentcategorizer.advices;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Builder
@Getter
@Setter
public class ApiError {
    HttpStatus status;
    String error;
    List<String> subErrors;
}
