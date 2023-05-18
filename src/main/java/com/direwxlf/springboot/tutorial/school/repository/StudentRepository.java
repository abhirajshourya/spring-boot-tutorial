package com.direwxlf.springboot.tutorial.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.direwxlf.springboot.tutorial.school.entity.Student;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);

    List<Student> findByFirstNameContaining(String name);

    // Native Named Param - write SQL Query directly.
    @Query(value = "SELECT * FROM tbl_student S WHERE S.email_address = :emailId", nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    // Transactional - Modifying Query
    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name = :firstName where email_address = :emailId", nativeQuery = true)
    int updateStudentByEmailId(@Param("firstName") String firstName, @Param("emailId") String emailId);
}
