package com.direwxlf.springboot.tutorial.school.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.direwxlf.springboot.tutorial.school.entity.Guardian;
import com.direwxlf.springboot.tutorial.school.entity.Student;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("johndoe@example.com")
                .firstName("John")
                .lastName("Doe")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
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

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println(studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> students = studentRepository.findByFirstName("John");
        System.out.println("students: " + students);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> students = studentRepository.findByFirstNameContaining("oh");
        System.out.println("students: " + students);
    }

    @Test
    public void updateStudentByEmailId(){
        studentRepository.updateStudentByEmailId("Mohan", "johndoe@example.com");
    }
}
