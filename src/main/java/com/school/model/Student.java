package com.school.model;

public class Student {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.id
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    private Long id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.student_id
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    private String studentId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column student.student_name
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    private String studentName;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.id
     *
     * @return the value of student.id
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.id
     *
     * @param id the value for student.id
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.student_id
     *
     * @return the value of student.student_id
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    public String getStudentId() {
        return studentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.student_id
     *
     * @param studentId the value for student.student_id
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column student.student_name
     *
     * @return the value of student.student_name
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column student.student_name
     *
     * @param studentName the value for student.student_name
     *
     * @mbggenerated Fri Dec 27 23:41:01 CST 2019
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName == null ? null : studentName.trim();
    }
}