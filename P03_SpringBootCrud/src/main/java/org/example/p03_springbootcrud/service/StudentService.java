package org.example.p03_springbootcrud.service;

import org.example.p03_springbootcrud.entity.Student;
import org.example.p03_springbootcrud.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository ){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudnet( ){

        return  studentRepository.findAll();

    }

    public Student getStudentbyId(Long id) {

        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("not found : " + id));
    }



    public void saveStudent( Student student){
        student.setIsDeleted(false);
        studentRepository.save(student);
    }

    public void updateStudent( Student student){
        student.setIsDeleted(false);
        studentRepository.save(student);
    }





}
