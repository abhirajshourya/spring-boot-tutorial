package com.direwxlf.springboot.tutorial.departmentapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.direwxlf.springboot.tutorial.departmentapp.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    List<Department> findAllByDepartmentNameIgnoreCase(String departmentName);
}
