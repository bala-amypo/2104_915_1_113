package com.example.demo.service.impl;

import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    @Override
    public String generateRecord(Long caseId) {
        return "Repeat Offender Record generated for Case ID: " + caseId;
    }
}
