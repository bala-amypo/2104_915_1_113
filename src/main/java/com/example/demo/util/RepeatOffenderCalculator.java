package com.example.demo.util;

import java.time.LocalDateTime;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

public class RepeatOffenderCalculator {

    public static RepeatOffenderRecord calculate(StudentProfile student, int totalCases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(totalCases);

        if (totalCases >= 5) {
            record.setRepeatOffender(true);
            record.setFlagSeverity("HIGH");
        } else if (totalCases >= 3) {
            record.setRepeatOffender(true);
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setRepeatOffender(false);
            record.setFlagSeverity("LOW");
        }

        record.setLastUpdated(LocalDateTime.now());
        return record;
    }
}
