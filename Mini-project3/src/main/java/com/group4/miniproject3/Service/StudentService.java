package com.group4.miniproject3.Service;

import com.group4.miniproject3.Entities.Student;
import com.group4.miniproject3.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public List<Student> findAll () {
        return studentRepository.findAll();
    }

    public Student findStudentById (Long id) { return studentRepository.findStudentById(id); }
}
