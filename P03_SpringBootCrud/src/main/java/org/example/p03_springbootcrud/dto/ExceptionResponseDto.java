package org.example.p03_springbootcrud.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {

    private Boolean success;
    private int statusCode;
    private String error;
    private String message;
    private String path;
    private LocalDateTime timestamp;

}
