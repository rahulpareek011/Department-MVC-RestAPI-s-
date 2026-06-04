package com.rahulscripts.departmentcategorizer.repositories;

import com.rahulscripts.departmentcategorizer.entity.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {

}
