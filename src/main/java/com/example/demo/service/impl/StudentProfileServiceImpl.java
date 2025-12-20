package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.*;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;

import java.util.List;

public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository studentRepo;
    private final IntegrityCaseRepository caseRepo;
    private final RepeatOffenderRecordRepository recordRepo;
    private final RepeatOffenderCalculator calculator;

    public StudentProfileServiceImpl(
            StudentProfileRepository studentRepo,
            IntegrityCaseRepository caseRepo,
            RepeatOffenderRecordRepository recordRepo,
            RepeatOffenderCalculator calculator
    ) {
        this.studentRepo = studentRepo;
        this.caseRepo = caseRepo;
        this.recordRepo = recordRepo;
        this.calculator = calculator;
    }

    @Override
    public StudentProfile createStudent(StudentProfile studentProfile) {
        studentProfile.setRepeatOffender(false);
        return studentRepo.save(studentProfile);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        return studentRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return studentRepo.findAll();
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = getStudentById(studentId);

        List<IntegrityCase> cases = caseRepo.findByStudentProfile(student);

        RepeatOffenderRecord record =
                recordRepo.findByStudentProfile(student)
                        .orElse(new RepeatOffenderRecord());

        RepeatOffenderRecord computed =
                calculator.computeRepeatOffenderRecord(student, cases);

        record.setStudentProfile(student);
        record.setTotalCases(computed.getTotalCases());
        record.setFirstIncidentDate(computed.getFirstIncidentDate());
        record.setFlagSeverity(computed.getFlagSeverity());

        recordRepo.save(record);

        student.setRepeatOffender(record.getTotalCases() >= 2);
        return studentRepo.save(student);
    }
}
