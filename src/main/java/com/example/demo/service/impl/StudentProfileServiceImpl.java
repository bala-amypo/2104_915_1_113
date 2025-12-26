package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Override
    public RepeatOffenderRecord evaluate(StudentProfile profile, int cases) {
        return RepeatOffenderCalculator.calculate(profile, cases);
    }
}
