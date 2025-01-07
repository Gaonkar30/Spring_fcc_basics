package com.fcc.SpringCourse;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
// trying to change the name of the table
@Table(name="New_Student")
public class Student {
    @Id
    @GeneratedValue // used to auto genereate simple primary key values not dervied keys and it must be under @Id
    private Integer id;
    // changing the properties of a column
    @Column(
            name="fname",
            length = 20
    )
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private int age;
    @ManyToOne
    @JoinColumn(name = "school_id")
    @JsonBackReference
    //tells that the child (student) does not need to serialize the parent(School)
    private School school;

    public StudentProfile getStudentProfile() {
        return studentProfile;
    }

    public void setStudentProfile(StudentProfile studentProfile) {
        this.studentProfile = studentProfile;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    // Creating relationships between tables
    @OneToOne(
            mappedBy = "student",
            cascade = CascadeType.ALL

    )
    private StudentProfile studentProfile;
    public Student() {
    }
    public Student(String firstName, String lastName, String email, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
