package com.school.mapper;

import com.school.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     *
     * 根据id删除
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     *
     * 插入
     */
    int insert(Student record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     *
     * 根据id获取信息
     */
    Student selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019、
     * 查询所有信息
     */
    List<Student> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table student
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     *
     * 根据id更新信息
     */
    int updateByPrimaryKey(Student record);

    /**
     * 根据学号 姓名获取信息
     * @param studentId
     * @param studentName
     * @return
     */
    Student findStudent(@Param("studentId") String studentId, @Param("studentName") String studentName);
}