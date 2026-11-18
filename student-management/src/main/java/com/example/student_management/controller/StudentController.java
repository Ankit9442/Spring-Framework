package com.example.student_management.controller;

import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent( @PathVariable @Positive Long id ){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(id));
    }

    @GetMapping
    public ResponseEntity<?>  getAllStudent(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudent());
    }

    @PostMapping
    public ResponseEntity<?> createStudent(@RequestBody @Valid StudentCreateRequest studentReq){
        studentService.createStudent(studentReq);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable  @Positive Long id , @Valid Student studentReq){
        studentService.updateStudent(id , studentReq);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deteleStudent( @PathVariable @Positive Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("soft-delete/{id}")
    public ResponseEntity<?> softDeteleStudent( @PathVariable @Positive Long id) {
        studentService.softDeleteStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
