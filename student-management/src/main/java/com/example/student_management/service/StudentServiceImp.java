package com.example.student_management.service;

import com.example.student_management.aspect.Audited;
import com.example.student_management.dto.request.StudentCreateRequest;
import com.example.student_management.dto.request.StudentUpdateRequest;
import com.example.student_management.dto.response.PageResponse;
import com.example.student_management.dto.response.StudentResponse;
import com.example.student_management.entity.Student;
import com.example.student_management.exception.DuplicateResourceException;
import com.example.student_management.exception.ResourceNotFoundException;
import com.example.student_management.mapper.StudentMapper;
import com.example.student_management.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    private static final Set<String> ALLOWED_SORT_FIELDS =
            Set.of("id", "firstName", "lastName", "email", "createdAt");


    @Override
    @Audited(action = "STUDENT_FETECHED")
    public StudentResponse getStudent(Long id) {
        return studentMapper.toResponse(findStudentOrThrow(id));
    }

    @Override
    public PageResponse<StudentResponse> getAllStudent( int page , int size , String sortBy , String direction ) {

        validatePagination(page , size , sortBy);
        Sort.Direction sortDirection ;

        try{
            sortDirection = Sort.Direction.fromString(direction);
        }catch (IllegalArgumentException ex ){
            throw new IllegalArgumentException(
                    "Sort direction must be ASC or DESC"
            );
        }

        Pageable pageable =  PageRequest.of( page , size , Sort.by(sortDirection, sortBy ) );

        Page<StudentResponse> studentPage =
                studentRepository.findAll(pageable)
                        .map(studentMapper::toResponse);

        return PageResponse.from(studentPage);
    }

    @Override
    @Transactional
    @Audited(action = "STUDENT_CREATED")
    public StudentResponse createStudent(StudentCreateRequest studentReq)  {
        if(studentRepository.existsByEmailIgnoreCase(studentReq.email())){
            throw new DuplicateResourceException("A student with this email already exist");
        }
        Student savedStudent =  studentRepository.save(studentMapper.mapToEntity(studentReq));

        return studentMapper.toResponse(savedStudent);
    }

    @Override
    @Transactional
    @Audited(action = "STUDENT_UPDATED")
    public StudentResponse updateStudent(Long id, StudentUpdateRequest studentReq) {

        if(studentRepository.existsByEmailIgnoreCaseAndIdNot(studentReq.email() , id)){
            throw new DuplicateResourceException("A student with this email already exist");
        }

        Student existingStudent = findStudentOrThrow(id);

        studentMapper.updateEntity(existingStudent , studentReq);

        Student updatedStudent  = studentRepository.save(existingStudent);
        return studentMapper.toResponse(updatedStudent );
    }

    @Override
    @Transactional
    @Audited(action = "STUDENT_DELETED")
    public void deleteStudent(Long id) {

        Student existingStudent = findStudentOrThrow(id);

        studentRepository.delete(existingStudent);
    }

    @Override
    @Transactional
    @Audited(action = "STUDENT_DELETED")
    public void softDeleteStudent(Long id) {

        Student existingStudent = findStudentOrThrow(id);

        existingStudent.setStatus("DELETED");

        studentRepository.save(existingStudent);

    }

    private void validatePagination(int page , int size , String sortBy){

        if(page < 0 ){
            throw new IllegalArgumentException("Invalid page number");
        }

        if(size < 1 || size  > 100){
            throw new IllegalArgumentException("Invalid page size");
        }

        if(!ALLOWED_SORT_FIELDS.contains(sortBy)){
            throw new IllegalArgumentException(
                    "Invalid sort field: " + sortBy
            );
        }
    }

    private Student findStudentOrThrow( Long id  ){
        return  studentRepository.findByIdAndStatus(id , "ACTIVE").orElseThrow(()-> new ResourceNotFoundException("Student with id : " + id + " Does not exist." ));
    }
}
