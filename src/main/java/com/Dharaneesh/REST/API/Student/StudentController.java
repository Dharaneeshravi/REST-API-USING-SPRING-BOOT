package com.Dharaneesh.REST.API.Student;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudent()
    {
        return new ResponseEntity<>(studentService.getStudent(), HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody Student student)
    {
        studentService.createStudent(student);
        return new ResponseEntity<>("CREATED SUCCESS",HttpStatus.CREATED);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id)
    {
        Student student=studentService.getStudentById(id);

        if(student!=null)
        {
            return new ResponseEntity<>(student,HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<String> updateStudentById(@PathVariable Long id,@RequestBody Student student)
    {
        boolean res=studentService.updateStudentById(id,student);

        if(res)
        {
            return new ResponseEntity<>("UPDATE SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id)
    {
        boolean res=studentService.deleteStudentById(id);

        if(res)
        {
            return new ResponseEntity<>("DELETED SUCCESS",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>("NOT_FOUND",HttpStatus.NOT_FOUND);
        }
    }
}
