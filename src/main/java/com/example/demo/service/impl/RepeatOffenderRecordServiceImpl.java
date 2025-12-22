package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepeatOffenderRecordServiceImpl
        implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RepeatOffenderRecord getByStudentId(Long studentId) {

        List<RepeatOffenderRecord> records =
                repository.findByStudentProfile_Id(studentId);

        if (records.isEmpty()) {
            throw new RuntimeException("Record not found");
        }

        // ✅ Return ONE record (first one)
        return records.get(0);
    }
}
