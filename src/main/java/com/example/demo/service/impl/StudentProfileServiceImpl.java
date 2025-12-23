package com.example.demo.service.impl;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.util.RepeatOffenderCalculator;
import org.springframework.stereotype.Service;

@Service
public class StudentProfileServiceImpl {

    public RepeatOffenderRecord evaluate(StudentProfile profile, int cases) {
        return RepeatOffenderCalculator.calculate(profile, cases);
    }
}
