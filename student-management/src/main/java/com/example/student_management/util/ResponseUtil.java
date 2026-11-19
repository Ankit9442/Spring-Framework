package com.example.student_management.util;

import com.example.student_management.dto.response.ApiErrorResponse;
import com.example.student_management.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.Map;

public class ResponseUtil {

    public static  ResponseEntity<ApiErrorResponse> buildErrorMessage(HttpStatus status ,
                                                                       String message ,
                                                                       String path ,
                                                                       Map<String , String > validationErrors){

        ApiErrorResponse response = new ApiErrorResponse(
                Instant.now(),
                status.value(),
                status.getReasonPhrase(),
                message,
                path,
                validationErrors
        );

        return ResponseEntity.status(status).body(response);
    }

    public static <T> ResponseEntity<ApiResponse<T>> buildSuccessMessage(
            HttpStatus status,
            String message,
            T data) {

        ApiResponse<T> response = new ApiResponse<>(
                status.value(),
                message,
                data
        );

        return ResponseEntity.status(status).body(response);
    }



}
