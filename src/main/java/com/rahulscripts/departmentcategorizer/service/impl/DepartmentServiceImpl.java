package com.rahulscripts.departmentcategorizer.service.impl;

import com.rahulscripts.departmentcategorizer.advices.ApiResponse;
import com.rahulscripts.departmentcategorizer.dto.DepartmentDto;
import com.rahulscripts.departmentcategorizer.entity.DepartmentEntity;
import com.rahulscripts.departmentcategorizer.repositories.DepartmentRepository;
import com.rahulscripts.departmentcategorizer.service.DepartmentService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
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
        if(!departmentRepository.existsById(id)) throw new EntityNotFoundException("Department Not found with this id: "+id);
    }

    @Override
    public DepartmentDto createNewDepartment(DepartmentDto departmentDto) {
        DepartmentEntity departmentEntity = modelMapper.map(departmentDto, DepartmentEntity.class);
        DepartmentEntity savedDepartment = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedDepartment,DepartmentDto.class);
    }

    @Override
    public String deleteDepartmentById(Long id) {
        isExistById(id);
        departmentRepository.deleteById(id);
        return "Deleted Id: "+id;
    }

    @Override
    public DepartmentDto getDepartmentById(Long id) {
        isExistById(id);
        Optional<DepartmentEntity> ent = departmentRepository.findById(id);
        return modelMapper.map(ent,DepartmentDto.class);
    }

    @Override
    public DepartmentDto patchDepartmentById(Long id, Map<String, Object> patches) {
        isExistById(id);
        DepartmentEntity departmentEntity = departmentRepository.findById(id).get();
        patches.forEach((fields,value) -> {
            Field reqFields = ReflectionUtils.findRequiredField(DepartmentEntity.class,fields);
            reqFields.setAccessible(true);
            ReflectionUtils.setField(reqFields,departmentEntity,value);
        });
        departmentRepository.save(departmentEntity);
        return modelMapper.map(departmentEntity,DepartmentDto.class);
    }

    @Override
    public DepartmentDto updateDepartment(Long id, DepartmentDto departmentDto) {
        isExistById(id);
        departmentDto.setId(id);
        DepartmentEntity depEntUdated = modelMapper.map(departmentDto,DepartmentEntity.class);
        departmentRepository.save(depEntUdated);
        return modelMapper.map(depEntUdated,DepartmentDto.class);
    }
}
