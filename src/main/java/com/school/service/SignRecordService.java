package com.school.service;

import com.school.model.SignRecord;

import java.util.List;

public interface SignRecordService {

    List<SignRecord> findStudentSignRecord(Long studentId);

    void singRecord(String studentId, String studentName, String ip);
}
