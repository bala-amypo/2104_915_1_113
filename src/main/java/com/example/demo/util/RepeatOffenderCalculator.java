package com.example.demo.util;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class RepeatOffenderCalculator {

    public RepeatOffenderRecord computeRepeatOffenderRecord(
            StudentProfile student,
            List<IntegrityCase> cases
    ) {
        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setStudentProfile(student);

        int totalCases = cases.size();
        record.setTotalCases(totalCases);

        if (!cases.isEmpty()) {
            LocalDate firstDate = cases.stream()
                    .map(IntegrityCase::getIncidentDate)
                    .filter(d -> d != null)
                    .min(Comparator.naturalOrder())
                    .orElse(null);
            record.setFirstIncidentDate(firstDate);
        }

        if (totalCases >= 4) {
            record.setFlagSeverity("HIGH");
        } else if (totalCases >= 2) {
            record.setFlagSeverity("MEDIUM");
        } else {
            record.setFlagSeverity("LOW");
        }

        return record;
    }
}
