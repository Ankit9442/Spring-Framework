package org.example.p03_springbootcrud.controller;

import org.example.p03_springbootcrud.entity.Student;
import org.example.p03_springbootcrud.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService ){
        this.studentService = studentService ;
    }

    @GetMapping
    public ResponseEntity<?> getAllStudent(){
        List<Student> students =  studentService.getAllStudnet();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent( @PathVariable Long id   ){
        Student student =  studentService.getStudentbyId(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }



    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody Student student){
        studentService.saveStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body("student created");
    }
}
