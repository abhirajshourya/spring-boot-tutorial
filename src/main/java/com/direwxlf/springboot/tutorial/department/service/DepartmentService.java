package com.direwxlf.springboot.tutorial.department.service;

import java.util.List;

import com.direwxlf.springboot.tutorial.department.entity.Department;
import com.direwxlf.springboot.tutorial.department.error.DepartmentNotFoundException;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    List<Department> fetchDepartmentsByName(String departmentName);

    Department fetchDepartmentByName(String departmentName);
}
