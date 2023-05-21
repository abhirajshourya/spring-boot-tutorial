package com.direwxlf.springboot.tutorial.school.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.direwxlf.springboot.tutorial.school.entity.Course;
import com.direwxlf.springboot.tutorial.school.entity.Teacher;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses() {
        List<Course> courses = courseRepository.findAll();
        System.out.println("Courses: " + courses);
    }

    @Test
    public void saveCourseWithTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Prakash")
                .lastName("Brooks")
                .build();
        Course course = Course.builder()
                .title("Python")
                .credit(7)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }
}
