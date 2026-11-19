package com.example.student_management.controller;

import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.dto.request.StudentUpdateRequest;
import com.example.student_management.dto.response.ApiResponse;
import com.example.student_management.dto.response.StudentResponse;
import com.example.student_management.service.StudentService;
import com.example.student_management.util.ResponseUtil;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/student")
@Validated
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudent(@PathVariable @Positive Long id ){
        return ResponseUtil.buildSuccessMessage(HttpStatus.OK , "Student retrieved successfully" ,studentService.getStudent(id));
    }

    @GetMapping
    public ResponseEntity<?>  getAllStudent(  @RequestParam(defaultValue = "0") int page ,
                                                                          @RequestParam(defaultValue = "5")int size ,
                                                                          @RequestParam(defaultValue = "id") String sortBy ,
                                                                          @RequestParam(defaultValue = "DESC") String direction  ){
        return ResponseUtil.buildSuccessMessage(HttpStatus.OK , "Students retrieved successfully", studentService.getAllStudent( page , size , sortBy , direction) );
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>> createStudent(@RequestBody @Valid StudentCreateRequest studentReq){
        return ResponseUtil.buildSuccessMessage(HttpStatus.CREATED , "Student created successfully" ,studentService.createStudent(studentReq));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> updateStudent(@PathVariable @Positive(message = "Student ID must be positive") Long id ,
                                                         @RequestBody  @Valid StudentUpdateRequest studentReq){
        return ResponseUtil.buildSuccessMessage(HttpStatus.OK ,  "Student updated successfully" ,studentService.getStudent(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deteleStudent( @PathVariable @Positive(message = "Student ID must be positive") Long id) {
        studentService.deleteStudent(id);
        return ResponseUtil.buildSuccessMessage(HttpStatus.NO_CONTENT , "Data deleted" , null);
    }

    @PatchMapping("soft-delete/{id}")
    public ResponseEntity<ApiResponse<Void>> softDeteleStudent( @PathVariable @Positive(message = "Student ID must be positive") Long id) {
        studentService.softDeleteStudent(id);
        return ResponseUtil.buildSuccessMessage(HttpStatus.NO_CONTENT , "Data deleted" , null);
    }


}
