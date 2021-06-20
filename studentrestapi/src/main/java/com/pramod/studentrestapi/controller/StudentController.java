package com.pramod.studentrestapi.controller;

import com.pramod.studentrestapi.entities.Student;
import com.pramod.studentrestapi.repos.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    
    @GetMapping(value = "/students/")
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    
    @GetMapping(value="/student/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        return studentRepository.findById(id).get();
    }

    @PostMapping(value = "/student/")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping(value="/student/")
    public Student updateStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @DeleteMapping(value="/student/{id}")
    public void deleteStudent(@PathVariable("id") int id) {
        studentRepository.deleteById(id);
    }
}
