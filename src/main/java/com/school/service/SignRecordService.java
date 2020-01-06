package com.school.service;

import com.school.model.SignRecord;

import java.util.List;

public interface SignRecordService {

    /**
     * 查询学生签到信息
     * @param studentId
     * @return
     */
    List<SignRecord> findStudentSignRecord(Long studentId);

    /**
     * 保存签到信息
     * @param studentId
     * @param studentName
     * @param ip
     */
    void singRecord(String studentId, String studentName, String ip);
}
