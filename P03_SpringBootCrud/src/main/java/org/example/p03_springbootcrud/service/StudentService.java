package org.example.p03_springbootcrud.service;

import org.example.p03_springbootcrud.dto.CreateStudentRequestDto;
import org.example.p03_springbootcrud.dto.CreateStudentResponseDto;
import org.example.p03_springbootcrud.entity.Student;
import org.example.p03_springbootcrud.exception.GlobalExceptionHandler;
import org.example.p03_springbootcrud.exception.ResourceNotFoundException;
import org.example.p03_springbootcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository ){
        this.studentRepository = studentRepository;
    }

    // get Student
    public Student getStudent(Long Id ){
        return studentRepository.findById(Id).orElseThrow(()-> new ResourceNotFoundException("Student Not found "));
    }

    // get All Student
    public List<Student>  getAllStudents( ){
          return  studentRepository.findAll();
    }

    // create student
    public CreateStudentResponseDto createStudent(CreateStudentRequestDto studentReqDto ){

        Student student = mapDtoToEntity(studentReqDto);

        studentRepository.save(student);

        return mapEntityToDto(student);
    }

    // update student
    public Student updateStudent(Long Id ,  Student studentReq ){

        Student existingStudent = studentRepository.findById(Id).orElseThrow(()-> new RuntimeException("Not found "));

        existingStudent.setName(studentReq.getName());
        existingStudent.setRollNo(studentReq.getRollNo());
        existingStudent.setSubject(studentReq.getSubject());
        existingStudent.setAge(studentReq.getAge());
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        return studentRepository.save(existingStudent);
    }

    // delete student
    public void deleteStudent(Long Id ){
         studentRepository.deleteById(Id);
    }

    // soft-delete student
    public void softDeleteStudent(Long Id ){

        Student existingStudent = studentRepository.findById(Id).orElseThrow(()-> new RuntimeException("Not found "));
        existingStudent.setDeleted(false);
        existingStudent.setUpdatedAt(LocalDateTime.now());

        studentRepository.save(existingStudent);
    }

    private Student  mapDtoToEntity(CreateStudentRequestDto studentReqDto) {
        Student student = new Student();

        student.setName(studentReqDto.getName());
        student.setAge(studentReqDto.getAge());
        student.setEmail(studentReqDto.getEmail());
        student.setRollNo(studentReqDto.getRollNo());
        student.setSubject(studentReqDto.getSubject());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        student.setDeleted(false);

        return student;

    }

    private CreateStudentResponseDto mapEntityToDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setId(student.getId());
        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setSubject(student.getSubject());
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;

    }



}
