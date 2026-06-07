package com.rahulscripts.departmentcategorizer.controller;

import com.rahulscripts.departmentcategorizer.advices.ApiResponse;
import com.rahulscripts.departmentcategorizer.dto.DepartmentDto;
import com.rahulscripts.departmentcategorizer.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/departments")
@RestController
public class DepartmentController {
    private final DepartmentService departmentService;

    DepartmentController(DepartmentService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAllDepartment(){
        return ResponseEntity.ok(departmentService.getAllDepartments());
    }

    @GetMapping("{id}")
    public ResponseEntity<List<DepartmentDto>> getDepartmentById(@PathVariable Long id){
        return ResponseEntity.ok(departmentService.getDepartmentById(id));
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> createNewDepartment(@RequestBody @Valid DepartmentDto departmentDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(departmentService.createNewDepartment(departmentDto));
    }

    @DeleteMapping
    public ResponseEntity<ApiResponse<String>> deleteDepartmentById(@RequestParam Long id){
        String resp = departmentService.deleteDepartmentById(id);
        return new ResponseEntity<>(new ApiResponse<>(resp),HttpStatus.OK);
    }

}
