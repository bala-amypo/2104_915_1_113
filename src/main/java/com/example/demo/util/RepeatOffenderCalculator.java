package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDateTime;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(StudentProfile student, List<IntegrityCase> cases) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);
        record.setTotalCases(cases.size());

        // Determine severity based on number of cases
        if (cases.size() == 1) {
            record.setFlagSeverity("LOW");
        } else if (cases.size() == 2) {
            record.setFlagSeverity("MEDIUM");
        } else if (cases.size() >= 3) {
            record.setFlagSeverity("HIGH");
        } else {
            record.setFlagSeverity("LOW");
        }

        record.setLastUpdated(LocalDateTime.now());
        return record;
    }
}
