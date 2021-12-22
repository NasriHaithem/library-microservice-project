package com.example.studentservice.Service;

import com.example.studentservice.model.Book;
import com.example.studentservice.model.Reservation;
import com.example.studentservice.model.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();
    public Student getStudentById(Long id);
    public Student saveStudent(Student student);
    public Student updateStudent(Student student);
    public String deleteStudentById(Long id);
    //public Reservation reserveBook(Student student, Book book);
}
