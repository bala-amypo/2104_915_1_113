package com.example.demo.repository;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepeatOffenderRecordRepository
        extends JpaRepository<RepeatOffenderRecord, Long> {

    // already added earlier
    List<RepeatOffenderRecord> findByStudentProfile_Id(Long studentId);

    // ✅ ADD THIS (fixes error 2)
    List<RepeatOffenderRecord> findByStudentProfile(StudentProfile studentProfile);
}
