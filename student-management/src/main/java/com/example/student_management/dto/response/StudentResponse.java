package com.example.student_management.dto.response;

import java.time.Instant;
import java.time.LocalDate;

public record StudentResponse (
    Long id,
    String firstName,
    String lastName,
    String email,
    String phoneNumber,
    LocalDate dateOfBirth,
    String status,
    Instant createdAt,
    Instant updatedAt
){}
