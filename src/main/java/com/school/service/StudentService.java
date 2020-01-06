package com.school.service;

import com.school.model.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    /**
     * 查询学生信息
     * @return
     */
    List<Student> findAll();

    /**
     * 保存学生信息
     * @param student
     * @return
     */
    int save(Student student);

    /**
     * 删除学生信息
     * @param id
     * @return
     */
    int delete(Long id);

    /**
     * 修改学生信息
     * @param student
     * @return
     */
    int update(Student student);

    /**
     * 根据id查询学生信息
     * @param id
     * @return
     */
    Optional<Student> findStudent(Long id);

    /**
     * 根据学号姓名查询学生信息
     * @param studentId
     * @param studentName
     * @return
     */
    Optional<Student> findStudent(String studentId, String studentName);
}
