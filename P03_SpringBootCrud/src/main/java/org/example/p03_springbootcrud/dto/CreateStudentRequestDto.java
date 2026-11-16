package org.example.p03_springbootcrud.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateStudentRequestDto {


    @NotBlank(message = "Student name is required")
    @Size(min = 2 , max = 50 , message = "Student name length should be between 2 to 50 characters")
    private String name;

    @NotNull(message = "Age is required")
    private Integer age;

    @NotNull(message = "Email is required")
    @Email
    private String email;

    @NotNull(message = "Roll No. is required")
    private Integer rollNo;

    @NotBlank(message = "Subject is required")
    private String subject;

}
