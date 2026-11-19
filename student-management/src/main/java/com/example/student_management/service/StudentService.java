package com.example.student_management.service;

import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.dto.request.StudentUpdateRequest;
import com.example.student_management.dto.response.PageResponse;
import com.example.student_management.dto.response.StudentResponse;


public interface StudentService {

    // get student
    StudentResponse getStudent(Long id );

    // get All student
    PageResponse<StudentResponse> getAllStudent( int page , int size , String sortBy , String direction );

    // create student
    StudentResponse createStudent(StudentCreateRequest studentReq );

    // update student
    StudentResponse updateStudent(Long id ,  StudentUpdateRequest studentReq );

    // delete student
    void deleteStudent(Long id);

    // Soft delete student
    void softDeleteStudent(Long id);



}
