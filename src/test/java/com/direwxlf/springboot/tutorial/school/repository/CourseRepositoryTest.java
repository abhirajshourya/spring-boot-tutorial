package com.direwxlf.springboot.tutorial.school.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import com.direwxlf.springboot.tutorial.school.entity.Course;
import com.direwxlf.springboot.tutorial.school.entity.Guardian;
import com.direwxlf.springboot.tutorial.school.entity.Student;
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

    @Test
    public void findAllPagination() {
        PageRequest firstPageWithThreeRecords = PageRequest.of(0, 3);

        // this will start from 1th page
        // PageRequest secondPageWithTwoRecords = PageRequest.of(1, 2);

        List<Course> courses = courseRepository.findAll(firstPageWithThreeRecords).getContent();

        Long totalElements = courseRepository.findAll(firstPageWithThreeRecords).getTotalElements();

        int totalPages = courseRepository.findAll(firstPageWithThreeRecords).getTotalPages();

        System.out.println("Total Courses: " + totalElements);
        System.out.println("Total Pages: " + totalPages);
        System.out.println("Courses with Pagination: " + courses);
    }

    @Test
    public void saveCourseWithStudentAndTeacher() {
        Teacher teacher = Teacher.builder()
                .firstName("Prakash")
                .lastName("Brooks")
                .build();
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(teacher)
                .build();

        Guardian guardian = Guardian.builder()
                .name("Jane Doe")
                .emailId("janedoe@example.com")
                .contact("9999900000").build();
        Student student = Student.builder()
                .emailId("johndoe@example.com")
                .firstName("John")
                .lastName("Doe")
                .guardian(guardian)
                .build();

        course.addStudents(student);

        courseRepository.save(course);
    }
}
