package com.school.service.impl;

import com.school.exception.UserNotExistException;
import com.school.mapper.SignRecordMapper;
import com.school.model.SignRecord;
import com.school.model.Student;
import com.school.service.SignRecordService;
import com.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
//对应的接口实现类
public class SignRecordServiceImpl implements SignRecordService {

    private final SignRecordMapper signRecordMapper;

    private final StudentService studentService;

    @Autowired
    public SignRecordServiceImpl(SignRecordMapper signRecordMapper,
                                 StudentService studentService) {
        this.signRecordMapper = signRecordMapper;
        this.studentService = studentService;
    }


    @Override
    public List<SignRecord> findStudentSignRecord(Long studentId) {
        return signRecordMapper.findStudentSignRecord(studentId);
    }

    @Override
    public void singRecord(String studentId, String studentName, String ip) {
        Student student = studentService.findStudent(studentId, studentName).orElseThrow(UserNotExistException::new);
        Date date = new Date();
        SignRecord studentSignRecordByDate = signRecordMapper.findStudentSignRecordByDate(student.getId(), date);
        if (studentSignRecordByDate != null) {
            studentSignRecordByDate.setIp(ip);
            studentSignRecordByDate.setSignTime(date);
            signRecordMapper.updateByPrimaryKey(studentSignRecordByDate);
        }else{
            SignRecord signRecord = new SignRecord();
            signRecord.setStudentId(student.getId());
            signRecord.setDate(date);
            signRecord.setSignTime(date);
            signRecord.setIp(ip);
            signRecordMapper.insert(signRecord);
        }
    }
}
