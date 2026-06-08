package com.rahulscripts.departmentcategorizer.customannotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

public class RolePatternValidator implements ConstraintValidator<RolePattern,String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null) return true;
        List<String> roles = List.of("ADMIN","USER");
        return roles.contains(s);
    }
}
