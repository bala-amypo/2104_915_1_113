package com.example.demo.service.impl;

import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.stereotype.Service;

@Service
public class RepeatOffenderRecordServiceImpl
        implements RepeatOffenderRecordService {

    @Override
    public String generateRecord(Long offenderId) {
        return "Repeat Offender Record generated for offender ID: " + offenderId;
    }
}
