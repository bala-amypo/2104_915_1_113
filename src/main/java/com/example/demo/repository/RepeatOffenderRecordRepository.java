package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

@Repository
public interface RepeatOffenderRecordRepository
        extends JpaRepository<RepeatOffenderRecord, Long> {

    // ✅ REQUIRED for your service call
    List<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
}
