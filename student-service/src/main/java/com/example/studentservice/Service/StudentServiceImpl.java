package com.example.studentservice.Service;

import com.example.studentservice.Repository.StudentRepository;
import com.example.studentservice.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }
    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    @Override
    public Student updateStudent(Student newStudent) {

        if(studentRepository.findById(newStudent.getId()).isPresent())
        {
            Student updatedStudent = studentRepository.findById(newStudent.getId()).get();

            if(newStudent.getNom() != null) updatedStudent.setNom(newStudent.getNom());
            if(newStudent.getPrenom() != null) updatedStudent.setPrenom(newStudent.getPrenom());

            return studentRepository.save(updatedStudent);
        }
        return null;
    }
    @Override
    public String deleteStudentById(Long id) {
        if(studentRepository.findById(id).isPresent())
        {
            studentRepository.deleteById(id);
            return "Successfully deleted";
        }
        return "No student with the provided ID";
    }


}
