package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    @Autowired
    private RepeatOffenderRecordRepository repeatOffenderRecordRepository;

    @Override
    public RepeatOffenderRecord findByStudent(StudentProfile student) {
        Optional<RepeatOffenderRecord> recordOpt = repeatOffenderRecordRepository.findByStudentProfile(student);
        return recordOpt.orElse(null);
    }

    @Override
    public RepeatOffenderRecord save(RepeatOffenderRecord record) {
        return repeatOffenderRecordRepository.save(record);
    }
}
