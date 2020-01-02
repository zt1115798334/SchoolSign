package com.school.service.impl;

import com.school.mapper.TeacherMapper;
import com.school.model.Teacher;
import com.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherServiceImpl(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }


    @Override
    public Optional<Teacher> findTeacher(String account, String password) {
        return Optional.ofNullable(teacherMapper.findTeacher(account, password));
    }
}
