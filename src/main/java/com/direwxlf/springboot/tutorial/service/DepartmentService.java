package com.direwxlf.springboot.tutorial.service;

import java.util.List;

import com.direwxlf.springboot.tutorial.entity.Department;
import com.direwxlf.springboot.tutorial.error.DepartmentNotFoundException;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    List<Department> fetchDepartmentByName(String departmentName);
}
