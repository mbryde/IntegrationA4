package com.group4.miniproject3.Repository;

import com.group4.miniproject3.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findAll();
    Student findStudentById(Long id);
}
