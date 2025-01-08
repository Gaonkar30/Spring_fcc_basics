package com.fcc.SpringCourse;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {
    public static Student toStudent(StudentDto dtoguy){
        Student newstud=new Student();
        newstud.setFirstName(dtoguy.firstName());
        newstud.setLastName(dtoguy.lastName());
        newstud.setEmail(dtoguy.email());
        //referencing with the school
        School newSchool=new School();
        newSchool.setId(dtoguy.schoolId());
        newstud.setSchool(newSchool);
        return newstud;
    }
    public static StudentResponseDto toStudentresponseDto(Student student){
        return new StudentResponseDto(student.getFirstName(),student.getLastName(),student.getEmail());
    }
}
