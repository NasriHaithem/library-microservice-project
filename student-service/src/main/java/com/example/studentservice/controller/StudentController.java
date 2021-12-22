package com.example.studentservice.controller;

import com.example.studentservice.Service.StudentService;
import com.example.studentservice.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/students/")
public class StudentController {

    private StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student>  getStudents() {
        return studentService.getStudents();
    }
    @GetMapping("{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }
    @PostMapping
    public Student  addStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }
    @PutMapping
    public Student  updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
    @DeleteMapping("{id}")
    public String  deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudentById(id);
    }


}
