package com.rahulscripts.departmentcategorizer.service;

import com.rahulscripts.departmentcategorizer.advices.ApiResponse;
import com.rahulscripts.departmentcategorizer.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DepartmentService {

    List<DepartmentDto> getAllDepartments();

    DepartmentDto createNewDepartment(DepartmentDto departmentDto);
}
