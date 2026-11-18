package com.example.filter_demo.service;

import com.example.filter_demo.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    public void createStudent(StudentDto student)
    {
        System.out.println("Name : "+ student.getName());
        System.out.println("Email : "+ student.getEmail());
        System.out.println("student created.");
    }

}
