package com.example.demo.service.impl;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.repository.RepeatOffenderRecordRepository;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import com.example.demo.util.RepeatOffenderCalculator;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    @Autowired
    private StudentProfileRepository studentProfileRepository;

    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;

    @Autowired
    private RepeatOffenderRecordRepository repeatOffenderRecordRepository;

    @Autowired
    private RepeatOffenderCalculator repeatOffenderCalculator;

    @Override
    public StudentProfile createStudent(StudentProfile student) {
        student.setRepeatOffender(false);
        return studentProfileRepository.save(student);
    }

    @Override
    public StudentProfile getStudentById(Long id) {
        Optional<StudentProfile> studentOpt = studentProfileRepository.findById(id);
        if (studentOpt.isEmpty()) {
            throw new ResourceNotFoundException("Student not found with id: " + id);
        }
        return studentOpt.get();
    }

    @Override
    public List<StudentProfile> getAllStudents() {
        return studentProfileRepository.findAll();
    }

    @Override
    public StudentProfile updateRepeatOffenderStatus(Long studentId) {
        StudentProfile student = getStudentById(studentId);
        List<IntegrityCase> cases = integrityCaseRepository.findByStudentProfile(student);
        RepeatOffenderRecord record = repeatOffenderCalculator.computeRepeatOffenderRecord(student, cases);

        // Save or update repeat offender record
        repeatOffenderRecordRepository.save(record);

        // Update student’s repeatOffender flag
        student.setRepeatOffender(record.getTotalCases() >= 2);
        return studentProfileRepository.save(student);
    }
}
