package com.example.student_management.dto.response;

public record ApiResponse<T>(
        int status,
        String message,
        T data
) {
}