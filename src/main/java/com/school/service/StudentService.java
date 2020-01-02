package com.school.service;

import com.school.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<Student> findAll();

    int save(Student student);

    int delete(Long id);

    int update(Student student);

    Optional<Student> findStudent(Long id);

    Optional<Student> findStudent(String studentId, String studentName);
}
