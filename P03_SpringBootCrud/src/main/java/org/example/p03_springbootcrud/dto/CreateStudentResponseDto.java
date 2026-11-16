package org.example.p03_springbootcrud.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateStudentResponseDto {
    private Long id;
    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
