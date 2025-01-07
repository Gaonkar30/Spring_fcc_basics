package com.fcc.SpringCourse;

import jakarta.persistence.*;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue
    private int id;
    private String bio;
    @OneToOne
    @JoinColumn(
            name = "student_id"
    )
    private Student student;
    public StudentProfile(String bio, int id) {
        this.bio = bio;
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentProfile() {
    }
}
