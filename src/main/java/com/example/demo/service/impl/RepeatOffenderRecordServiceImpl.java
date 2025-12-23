package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;

@Service
public class RepeatOffenderRecordServiceImpl {

    private final RepeatOffenderRecordRepository repeatOffenderRecordRepository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repeatOffenderRecordRepository) {
        this.repeatOffenderRecordRepository = repeatOffenderRecordRepository;
    }

    public RepeatOffenderRecord getLatestByStudent(StudentProfile studentProfile) {

        List<RepeatOffenderRecord> records =
                repeatOffenderRecordRepository.findByStudentProfile(studentProfile);

        if (records.isEmpty()) {
            return null; // or throw exception if you prefer
        }

        // return the most recent record (last one)
        return records.get(records.size() - 1);
    }

    public RepeatOffenderRecord save(RepeatOffenderRecord record) {
        return repeatOffenderRecordRepository.save(record);
    }
}
