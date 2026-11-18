package com.example.student_management.exception;

import com.example.student_management.dto.response.ApiErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.Map;
import java.util.MissingFormatArgumentException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runTimeExceptionHandler(RuntimeException ex  , HttpServletRequest request){

        return buildErrorMessage( HttpStatus.INTERNAL_SERVER_ERROR , ex.getMessage() , request.getRequestURI()  , null);

    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(ResourceNotFoundException ex  , HttpServletRequest request){

        return buildErrorMessage( HttpStatus.NOT_FOUND , ex.getMessage() , request.getRequestURI()  , null);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException ex  , HttpServletRequest request){

        Map<String, String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(
                         error -> error.getField(),
                        error ->error.getDefaultMessage(),
                        ( first , second  ) -> first
                ) );



        return buildErrorMessage( HttpStatus.BAD_REQUEST ,"Validation failed", request.getRequestURI()  , errors);

    }




    private ResponseEntity<ApiErrorResponse> buildErrorMessage(HttpStatus status ,  String message , String path , Map<String , String > validationErrors){

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





}
