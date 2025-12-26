package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.RepeatOffenderRecordRepository;

@Service
public class RepeatOffenderRecordServiceImpl {

    private final RepeatOffenderRecordRepository repository;

    public RepeatOffenderRecordServiceImpl(
            RepeatOffenderRecordRepository repository) {
        this.repository = repository;
    }

    public List<RepeatOffenderRecord> getByStudent(StudentProfile student) {
        return repository.findByStudentProfile(student);
    }
}
