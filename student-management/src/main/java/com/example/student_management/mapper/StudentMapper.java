package com.example.student_management.mapper;

import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.dto.request.StudentUpdateRequest;
import com.example.student_management.dto.response.StudentResponse;
import com.example.student_management.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public Student mapToEntity(StudentCreateRequest request){

        Student student = new Student();

        student.setFirstName(request.firstName().trim());
        student.setLastName(request.lastName().trim());
        student.setEmail(request.email().trim().toLowerCase());
        student.setPhoneNumber(request.phoneNumber());
        student.setDateOfBirth(request.dateOfBirth());
        student.setStatus("ACTIVE");

        return student;
    }

    public StudentResponse toResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getDateOfBirth(),
                student.getStatus(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }

    public void updateEntity(
            Student student,
            StudentUpdateRequest request) {

        student.setFirstName(request.firstName().trim());
        student.setLastName(request.lastName().trim());
        student.setEmail(request.email().trim().toLowerCase());
        student.setPhoneNumber(request.phoneNumber());
        student.setDateOfBirth(request.dateOfBirth());
    }





}
