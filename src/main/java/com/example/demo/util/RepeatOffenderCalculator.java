package com.example.demo.util;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

public class RepeatOffenderCalculator {

    public static RepeatOffenderRecord calculate(StudentProfile profile, int cases) {

        RepeatOffenderRecord record = new RepeatOffenderRecord();
        record.setTotalCases(cases);
        record.setRepeatOffender(cases >= 2);

        return record;
    }
}
