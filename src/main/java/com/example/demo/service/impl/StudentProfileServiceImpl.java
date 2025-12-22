package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl
        implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final RepeatOffenderRecordRepository recordRepo;

    public StudentProfileServiceImpl(
            StudentProfileRepository studentRepo,
            RepeatOffenderRecordRepository recordRepo) {
        this.studentRepo = studentRepo;
        this.recordRepo = recordRepo;
    }

    @Override
    public void updateRepeatOffenderStatus(Long studentId) {

        StudentProfile student =
                studentRepo.findById(studentId)
                        .orElseThrow(() ->
                                new RuntimeException("Student not found"));

        List<RepeatOffenderRecord> records =
                recordRepo.findByStudentProfile(student);

        student.setRepeatOffender(!records.isEmpty());

        studentRepo.save(student);
    }
}
