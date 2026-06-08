package com.rahulscripts.departmentcategorizer.service;

import com.rahulscripts.departmentcategorizer.advices.ApiResponse;
import com.rahulscripts.departmentcategorizer.dto.DepartmentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface DepartmentService {

    List<DepartmentDto> getAllDepartments();

    DepartmentDto createNewDepartment(DepartmentDto departmentDto);

    String deleteDepartmentById(Long id);

    DepartmentDto getDepartmentById(Long id);

    DepartmentDto patchDepartmentById(Long id, Map<String, Object> patches);

    DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto);
}
