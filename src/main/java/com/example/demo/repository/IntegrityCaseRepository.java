package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.entity.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile(StudentProfile studentProfile);

    List<IntegrityCase> findByStatus(String status);

    List<IntegrityCase> findByIncidentDateBetween(LocalDate from, LocalDate to);

    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.studentProfile.studentId = :studentId")
    List<IntegrityCase> findByStudentIdentifier(@Param("studentId") String studentId);

    @Query("SELECT ic FROM IntegrityCase ic WHERE ic.status = :status AND ic.incidentDate >= :since")
    List<IntegrityCase> findRecentCasesByStatus(@Param("status") String status, @Param("since") LocalDate since);
}
