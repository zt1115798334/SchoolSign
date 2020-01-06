package com.school.service;

import com.school.model.Teacher;

import java.util.Optional;

public interface TeacherService {

    /**
     * 根据账户密码查询教师信息
     * @param account
     * @param password
     * @return
     */
    Optional<Teacher> findTeacher(String account, String password);
}
