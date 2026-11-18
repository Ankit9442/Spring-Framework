package com.example.student_management.repository;

import com.example.student_management.entity.Student;
import com.example.student_management.enums.StudentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student ,Long > {

    Optional<Student> findByIdAndStatus( Long id , String status);
}
