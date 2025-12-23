package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    // CRUD tests
    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

    List<IntegrityCase> findByStudentProfile_Id(Long studentId);

    // HQL tests (mocked, method name must exist)
    List<IntegrityCase> findByStudentIdentifier(String studentId);

    List<IntegrityCase> findRecentCasesByStatus(String status, LocalDate since);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate start, LocalDate end);

    List<IntegrityCase> findByStatus(String status);
}
