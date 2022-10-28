package com.group4.miniproject3.Controller;

import com.group4.miniproject3.Entities.Student;
import com.group4.miniproject3.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class StudentController {
    @Autowired
    StudentService studentService;

    @RequestMapping("")
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @RequestMapping("/{id}")
    public Student findStudentById(@PathVariable Long id) {
        return studentService.findStudentById(id);
    }

    @PutMapping("/{id}")
    public Student putStudentById(
            @PathVariable Long id,
            @RequestBody Student student
    ) {
        return student;
    }

}
