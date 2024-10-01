package com.Dharaneesh.REST.API.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudent();

    void createStudent(Student student);

    Student getStudentById(Long id);

    boolean updateStudentById(Long id, Student student);

    boolean deleteStudentById(Long id);
}
