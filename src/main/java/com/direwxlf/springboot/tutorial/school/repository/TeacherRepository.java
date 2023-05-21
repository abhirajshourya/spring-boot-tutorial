package com.direwxlf.springboot.tutorial.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.direwxlf.springboot.tutorial.school.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}
