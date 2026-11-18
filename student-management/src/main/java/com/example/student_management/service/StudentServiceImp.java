package com.example.student_management.service;

import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.dto.response.StudentResponse;
import com.example.student_management.entity.Student;
import com.example.student_management.enums.StudentStatus;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void createStudent(StudentCreateRequest studentReq) {
        studentRepository.save(mapToEntity(studentReq));
    }

    @Override
    public StudentResponse getStudent(Long id) {
        return toResponse(findStudentOrThrow(id));
    }

    @Override
    public List<StudentResponse> getAllStudent() {

        return  studentRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Override
    public void updateStudent(Long id, Student studentReq) {

        Student existingStudent = findStudentOrThrow(id);

        existingStudent.setFirstName(studentReq.getFirstName());
        existingStudent.setLastName(studentReq.getLastName());

        studentRepository.save(existingStudent);

    }

    @Override
    public void deleteStudent(Long id) {

        Student existingStudent = findStudentOrThrow(id);

        studentRepository.delete(existingStudent);
    }

    @Override
    public void softDeleteStudent(Long id) {

        Student existingStudent = findStudentOrThrow(id);

        existingStudent.setStatus("DELETED");

        studentRepository.save(existingStudent);

    }

    private Student mapToEntity(StudentCreateRequest request){

        Student student = new Student();

        student.setFirstName(request.firstName().trim());
        student.setLastName(request.lastName().trim());
        student.setEmail(request.email().trim().toLowerCase());
        student.setPhoneNumber(request.phoneNumber());
        student.setDateOfBirth(request.dateOfBirth());
        student.setStatus("ACTIVE");

        return student;
    }

    public StudentResponse toResponse(Student student) {

        return new StudentResponse(
                student.getId(),
                student.getFirstName(),
                student.getLastName(),
                student.getEmail(),
                student.getPhoneNumber(),
                student.getDateOfBirth(),
                student.getStatus(),
                student.getCreatedAt(),
                student.getUpdatedAt()
        );
    }


    private Student findStudentOrThrow( Long id  ){
        return  studentRepository.findByIdAndStatus(id , "ACTIVE").orElseThrow(()-> new ResourceNotFoundException("Student with id : " + id + " Does not exist." ));
    }
}
