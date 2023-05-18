package com.direwxlf.springboot.tutorial.departmentapp.service;

import java.util.List;

import com.direwxlf.springboot.tutorial.departmentapp.entity.Department;
import com.direwxlf.springboot.tutorial.departmentapp.error.DepartmentNotFoundException;

public interface DepartmentService {
    Department saveDepartment(Department department);

    List<Department> fetchDepartmentList();

    Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentId);

    Department updateDepartment(Long departmentId, Department department);

    List<Department> fetchDepartmentByName(String departmentName);
}
