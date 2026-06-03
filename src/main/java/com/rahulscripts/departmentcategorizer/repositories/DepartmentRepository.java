package com.rahulscripts.departmentcategorizer.repositories;

import com.rahulscripts.departmentcategorizer.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

}
