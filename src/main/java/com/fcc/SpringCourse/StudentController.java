package com.fcc.SpringCourse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {



    private final StudentRepository repository;

    public StudentController(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }
// service layer's code
    private final StudentMapper studentMapper;


    // performing crud operations
    //create
    @PostMapping("/Students")
    public StudentResponseDto post(@RequestBody StudentDto dtoguy){
        var student=StudentMapper.toStudent(dtoguy);
        var savedstud=repository.save(student); // to make the student persistent
        return StudentMapper.toStudentresponseDto(savedstud); // to not expose extra info like attributes that are null in response
    }
    // converting dtostudent to student object
//    private Student toStudent(StudentDto dtoguy){
//        Student newstud=new Student();
//        newstud.setFirstName(dtoguy.firstName());
//        newstud.setLastName(dtoguy.lastName());
//        newstud.setEmail(dtoguy.email());
//        //referencing with the school
//        School newSchool=new School();
//        newSchool.setId(dtoguy.schoolId());
//        newstud.setSchool(newSchool);
//        return newstud;
//    }
//    private StudentResponseDto toStudentresponseDto(Student student){
//        return new StudentResponseDto(student.getFirstName(),student.getLastName(),student.getEmail());
//    }
    //get
    @GetMapping("/Students/{student-id}")
    public Student getStudentById(@PathVariable("student-id") Integer id){
        return repository.findById(id)
                .orElse(null);
    }
    @GetMapping("/Students")
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    // creating custom methods
    @GetMapping("/Students/search/{student-name}")
    public List<Student> findStudentByName(@PathVariable("student-name") String name){
        return repository.findAllByfirstNameContaining(name);
    }
    //Deleting
    @DeleteMapping("/Students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("student-id") Integer id){
        repository.deleteById(id);
    }




    //    @GetMapping("/")
//    @ResponseStatus(HttpStatus.ACCEPTED)
//    public String sayHello() {
//        return "Hello From Controller";
//    }
//    @PostMapping("/post")
//    @ResponseStatus(HttpStatus.CREATED)
//    public String posted(@RequestBody String message){
//        return "Message recieved "+ message;
//    }

//
//    @PostMapping("/post-order")
//    public String postedOrder(@RequestBody Order order){
//        return "Order Placed " +order.toString();
//    }
//    // to get details from the path variable
//    @GetMapping("/hello/{user-name}")
//    public String sayhello(@PathVariable("user-name") String Username){
//        return "Hi to "+Username;
//    }
//    // to access request parameters
//    @GetMapping("/bye")
//    public String getreqParams(@RequestParam("user-name") String userName,
//                               @RequestParam("user-lastname") String userLastName){
//        return "Hi "+ userName + " "+ userLastName;
//    }
}
