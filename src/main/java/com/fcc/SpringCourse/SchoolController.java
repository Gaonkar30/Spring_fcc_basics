package com.fcc.SpringCourse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @PostMapping("/schools")
    public School create(
            @RequestBody School school
    ){
        return schoolRepository.save(school);
    }
    @GetMapping("/schools")
    public List<School> getSchools(){
        return schoolRepository.findAll();
    }
    @DeleteMapping("/schools/{school-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteSchool(@PathVariable("school-id") Integer id){
        schoolRepository.deleteById(id);
    }
}
