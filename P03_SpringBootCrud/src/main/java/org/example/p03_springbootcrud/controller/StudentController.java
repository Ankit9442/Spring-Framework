package org.example.p03_springbootcrud.controller;

import jakarta.validation.Valid;
import org.example.p03_springbootcrud.dto.CreateStudentRequestDto;
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
    public ResponseEntity<?> getAllStudents(){
        List<Student> students =  studentService.getAllStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent( @PathVariable Long id   ){
        Student student =  studentService.getStudent(id);
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@Valid  @RequestBody CreateStudentRequestDto studentReqDto){
        studentService.createStudent(studentReqDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("student created");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent( @PathVariable Long Id ,  @RequestBody Student student){
        studentService.updateStudent(Id , student);
        return ResponseEntity.status(HttpStatus.OK).body("student updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent( @PathVariable Long id   ){
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PatchMapping("soft-delete/{id}")
    public ResponseEntity<?> softDeleteStudent( @PathVariable Long id   ){
        studentService.softDeleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
