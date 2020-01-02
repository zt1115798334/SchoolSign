package com.school.service;

import com.school.model.Teacher;

import java.util.Optional;

public interface TeacherService {

    Optional<Teacher> findTeacher(String account, String password);
}
