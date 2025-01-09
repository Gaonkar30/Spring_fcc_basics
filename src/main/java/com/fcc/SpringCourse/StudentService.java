package com.fcc.SpringCourse;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;
    private final StudentMapper studentMapper;
    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }
    public StudentResponseDto saveStudent(StudentDto dtoguy){
        var student=StudentMapper.toStudent(dtoguy);
        var savedstud=repository.save(student); // to make the student persistent
        return StudentMapper.toStudentresponseDto(savedstud);
    }
}
