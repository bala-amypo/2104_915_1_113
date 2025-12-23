package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDateTime;

public class RepeatOffenderCalculator {

    public static RepeatOffenderRecord calculate(StudentProfile student, int cases) {

        boolean repeatOffender = cases >= 3;

        RepeatOffenderRecord record =
                new RepeatOffenderRecord(repeatOffender, cases);

        record.setStudentProfile(student);

        if (cases >= 5) {
            record.setFlagSeverity("HIGH");
        } else if (cases >= 3) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("LOW");
        }

        record.setLastUpdated(LocalDateTime.now());

        return record;
    }
}
