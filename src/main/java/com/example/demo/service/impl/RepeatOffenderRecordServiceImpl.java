package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.service.RepeatOffenderRecordService;

@Service
public class RepeatOffenderRecordServiceImpl implements RepeatOffenderRecordService {

    @Override
    public String generateRecord(Long offenderId) {
        return "Repeat Offender Record generated for ID: " + offenderId;
    }
}
