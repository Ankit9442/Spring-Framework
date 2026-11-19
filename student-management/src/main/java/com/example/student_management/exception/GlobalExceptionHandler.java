package com.example.student_management.exception;

import com.example.student_management.dto.response.ApiErrorResponse;
import com.example.student_management.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException exception  , HttpServletRequest request){

        return ResponseUtil.buildErrorMessage( HttpStatus.NOT_FOUND , exception.getMessage() , request.getRequestURI()  , null);

    }

    @ExceptionHandler(DuplicateResourceException.class)
    public ResponseEntity<ApiErrorResponse> duplicateResourceExceptionHandler(DuplicateResourceException exception ,
                                                                              HttpServletRequest request){
        return ResponseUtil.buildErrorMessage(HttpStatus.CONFLICT , exception.getMessage() , request.getRequestURI() , null  );
    }

    // DTO validation: @Valid @RequestBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodArgumentNotValid(
            MethodArgumentNotValidException exception,
            HttpServletRequest request) {

        Map<String, String> errors = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                        error -> error.getField(),
                        error -> error.getDefaultMessage(),
                        (first, second) -> first
                ));

        return ResponseUtil.buildErrorMessage(
                HttpStatus.BAD_REQUEST,
                "Validation failed",
                request.getRequestURI(),
                errors
        );
    }


    // Constraint validation
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ApiErrorResponse> handleConstraintViolation(
            ConstraintViolationException exception,
            HttpServletRequest request) {

        Map<String, String> errors = exception.getConstraintViolations()
                .stream()
                .collect(Collectors.toMap(
                        violation -> violation.getPropertyPath().toString().substring(
                                violation.getPropertyPath().toString().lastIndexOf('.') + 1
                        ),
                        violation -> violation.getMessage(),
                        (first, second) -> first
                ));

        return ResponseUtil.buildErrorMessage(
                HttpStatus.BAD_REQUEST,
                "Validation failed",
                request.getRequestURI(),
                errors
        );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiErrorResponse> illegalArgumentExceptionHandler(IllegalArgumentException exception ,
                                                                            HttpServletRequest request){
        return ResponseUtil.buildErrorMessage( HttpStatus.BAD_REQUEST ,
                exception.getMessage() , request.getRequestURI()  , null);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ApiErrorResponse> handleMethodNotSupported(
            HttpRequestMethodNotSupportedException exception,
            HttpServletRequest request) {

        return ResponseUtil.buildErrorMessage(
                HttpStatus.METHOD_NOT_ALLOWED,
                "HTTP method '" + exception.getMethod()
                        + "' is not supported for this endpoint",
                request.getRequestURI(),
                null
        );
    }



        // Generic fallback - keep this LAST
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleException(
            Exception ex,
            HttpServletRequest request) {

        return ResponseUtil.buildErrorMessage(
                HttpStatus.INTERNAL_SERVER_ERROR,
                "Something went wrong",
                request.getRequestURI(),
                null
        );
    }

}
