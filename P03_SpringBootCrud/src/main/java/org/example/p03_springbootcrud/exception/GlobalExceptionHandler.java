package org.example.p03_springbootcrud.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.example.p03_springbootcrud.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionResponseDto> RunTimeException(  RuntimeException ex , HttpServletRequest httpRequest ){

        ExceptionResponseDto response = new ExceptionResponseDto(
                false,
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "Something went wrong",
                httpRequest.getServletPath(),
                LocalDateTime.now()

        );

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> NotFoundException(ResourceNotFoundException ex , HttpServletRequest httpRequest){

        ExceptionResponseDto response = new ExceptionResponseDto(
                false,
                HttpStatus.NOT_FOUND.value(),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getMessage(),
                httpRequest.getServletPath(),
                LocalDateTime.now()

        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);

    }


}
