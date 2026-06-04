package com.rahulscripts.departmentcategorizer.controller;

import com.rahulscripts.departmentcategorizer.advices.ApiResponse;
import com.rahulscripts.departmentcategorizer.dto.DepartmentDto;
import com.rahulscripts.departmentcategorizer.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/departments")
@RestController
public class DepartmentController {
    DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @PostMapping
    public ApiResponse<ResponseEntity<?>> createNewDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        departmentService.createNewDepartment(departmentDto);
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

}
