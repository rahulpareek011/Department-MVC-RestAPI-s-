package com.rahulscripts.departmentcategorizer.service.impl;

import com.rahulscripts.departmentcategorizer.advices.ApiResponse;
import com.rahulscripts.departmentcategorizer.dto.DepartmentDto;
import com.rahulscripts.departmentcategorizer.repositories.DepartmentRepository;
import com.rahulscripts.departmentcategorizer.service.DepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;

import java.util.List;
import java.util.NoSuchElementException;

public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    DepartmentServiceImpl(DepartmentRepository departmentRepository, ModelMapper modelMapper){
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        return departmentRepository.findAll()
                .stream()
                .map(m -> modelMapper.map(m,DepartmentDto.class))
                .toList();
    }

    public void isExistById(Long id){
        if(departmentRepository.existsById(id)) throw new NoSuchElementException();
    }

    @Override
    public ApiResponse<ResponseEntity<?>> createNewDepartment(DepartmentDto departmentDto) {
        modelMapper.map(departmentDto)
    }
}
