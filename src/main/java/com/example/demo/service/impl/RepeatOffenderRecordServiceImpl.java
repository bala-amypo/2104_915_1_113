package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    private final RepeatOffenderRecordRepository repository;

    public RepeatOffenderRecordServiceImpl(RepeatOffenderRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public RepeatOffenderRecord getByStudentId(Long studentId) {
        return repository.findByStudentProfile_Id(studentId)
                .orElseThrow(() -> new RuntimeException("Record not found"));
    }
}
