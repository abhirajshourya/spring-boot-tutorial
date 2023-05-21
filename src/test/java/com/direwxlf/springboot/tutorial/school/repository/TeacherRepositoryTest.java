package com.direwxlf.springboot.tutorial.school.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.direwxlf.springboot.tutorial.school.entity.Course;
import com.direwxlf.springboot.tutorial.school.entity.Teacher;

@SpringBootTest
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseCS = Course.builder()
                .title("Cyber Security")
                .credit(5)
                .build();
        Course courseISEE = Course.builder()
                .title("ISEE")
                .credit(5)
                .build();
        Teacher teacher = Teacher.builder()
                .firstName("Andrea")
                .lastName("Brooks")
                .courses(List.of(courseCS, courseISEE))
                .build();
        teacherRepository.save(teacher);
    }
}
