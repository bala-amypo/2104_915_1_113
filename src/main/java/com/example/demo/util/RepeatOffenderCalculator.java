package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDateTime;

public class RepeatOffenderCalculator {

    public static RepeatOffenderRecord calculate(StudentProfile profile, int cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(profile);
        record.setTotalCases(cases);

        if (cases <= 1) {
            record.setFlagSeverity("LOW");
        } else if (cases <= 3) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("HIGH");
        }

        record.setLastUpdated(LocalDateTime.now());
        return record;
    }
}
