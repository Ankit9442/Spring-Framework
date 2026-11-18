package com.example.student_management.service;

import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.dto.response.StudentResponse;
import com.example.student_management.entity.Student;

import java.util.List;


public interface StudentService {

    // create student
    void createStudent(StudentCreateRequest studentReq );

    // get student
    StudentResponse getStudent(Long id );

    // get All student
    List<StudentResponse> getAllStudent();

    // update student
    void updateStudent(Long id ,  Student studentReq );

    // delete student
    void deleteStudent(Long id);

    // Soft delete student
    void softDeleteStudent(Long id);



}
