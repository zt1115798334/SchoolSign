package com.school.service.impl;


import com.school.mapper.StudentMapper;
import com.school.model.Student;
import com.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {


    private final StudentMapper studentMapper;

    @Autowired
    public StudentServiceImpl(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public List<Student> findAll() {
        System.out.println("StudentServiceImpl.findAll");
        return studentMapper.selectAll();
    }

    @Override
    public int save(Student student) {
        return studentMapper.insert(student);
    }

    @Override
    public int delete(Long id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Student student) {

        return studentMapper.updateByPrimaryKey(student);
    }

    @Override
    public Optional<Student> findStudent(Long id) {
        return Optional.ofNullable(studentMapper.selectByPrimaryKey(id));
    }

    @Override
    public Optional<Student> findStudent(String studentId, String studentName) {
        return Optional.ofNullable(studentMapper.findStudent(studentId, studentName));
    }
}
