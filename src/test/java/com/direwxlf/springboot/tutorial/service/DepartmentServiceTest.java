package com.direwxlf.springboot.tutorial.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.direwxlf.springboot.tutorial.departmentapp.entity.Department;
import com.direwxlf.springboot.tutorial.departmentapp.error.DepartmentNotFoundException;
import com.direwxlf.springboot.tutorial.departmentapp.repository.DepartmentRepository;
import com.direwxlf.springboot.tutorial.departmentapp.service.DepartmentService;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    private DepartmentService departmentService;
    @MockBean
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IT")
                .departmentAddress("Bangalore")
                .departmentCode("IT-69")
                .departmentId(1L)
                .build();

        Mockito.when(departmentRepository.findById(1L)).thenReturn(Optional.of(department));
    }

    @Test
    @DisplayName("Get Data based on Valid Department Id")
    public void whenValidDepartmentName_thenDepartmentShouldBeFound() throws DepartmentNotFoundException {
        Long departmentId = 1L;
        Department found = departmentService.fetchDepartmentById(departmentId);

        assertEquals(departmentId, found.getDepartmentId());
    }
}