package com.Dharaneesh.REST.API.Student.StudentServiceImp;

import com.Dharaneesh.REST.API.Student.Student;
import com.Dharaneesh.REST.API.Student.StudentRepository;
import com.Dharaneesh.REST.API.Student.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceimp implements StudentService {


    private StudentRepository studentRepository;

    public StudentServiceimp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void createStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateStudentById(Long id, Student student) {
        Optional<Student> student1=studentRepository.findById(id);
        if(student1.isPresent())
        {
            Student student2=student1.get();
            student2.setName(student.getName());
            student2.setDepartment(student.getDepartment());
            student2.setEmail(student.getEmail());
            student2.setAddress(student.getAddress());
            studentRepository.save(student2);
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean deleteStudentById(Long id) {
        if(studentRepository.existsById(id))
        {
            studentRepository.deleteById(id);
            return true;
        }
        else
        {
            return false;
        }
    }
}
