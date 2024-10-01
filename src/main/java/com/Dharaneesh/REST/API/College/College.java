package com.Dharaneesh.REST.API.College;

import com.Dharaneesh.REST.API.Review.Review;
import com.Dharaneesh.REST.API.Student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long code;
    private String location;

    @JsonIgnore
    @OneToMany(mappedBy = "college")
    private List<Student> studentList;

    @OneToMany
    private List<Review> reviewList;

    public College() {
    }

    public College(Long id, String name, Long code, String location) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.location = location;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
