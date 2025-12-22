package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final RepeatOffenderRecordRepository recordRepo;

    public StudentProfileServiceImpl(
            RepeatOffenderRecordRepository recordRepo) {
        this.recordRepo = recordRepo;
    }

    @Override
    public RepeatOffenderRecord getRepeatOffenderRecord(
            StudentProfile studentProfile) {

        List<RepeatOffenderRecord> records =
                recordRepo.findByStudentProfile(studentProfile);

        return records.isEmpty()
                ? new RepeatOffenderRecord()
                : records.get(0);
    }
}
