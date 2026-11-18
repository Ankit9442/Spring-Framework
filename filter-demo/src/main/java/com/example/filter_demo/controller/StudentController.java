package com.example.filter_demo.controller;

import com.example.filter_demo.dto.StudentDto;
import com.example.filter_demo.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;


    @PostMapping
    public ResponseEntity<String> createStudent( @RequestBody StudentDto student){
        studentService.createStudent( student);
        return ResponseEntity.status(HttpStatus.OK).body("student created.");
    }
}
