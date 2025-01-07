package com.fcc.SpringCourse;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//Jparepo is a common/ generic repo
// no need to use @Repository / @Component annotation as Spring can understand it automatically
public interface StudentRepository extends JpaRepository<Student,Integer>{
    List<Student> findAllByfirstNameContaining(String firstName);
}