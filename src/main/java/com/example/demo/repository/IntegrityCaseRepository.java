package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.IntegrityCase;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    List<IntegrityCase> findByStudentProfile_Id(Long studentProfileId);
}
