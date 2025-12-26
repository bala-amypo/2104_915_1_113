package com.example.demo.repository;

import com.example.demo.entity.IntegrityCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IntegrityCaseRepository extends JpaRepository<IntegrityCase, Long> {

    // Spring matches "StudentIdentifier" in the name to the field in the Entity
    List<IntegrityCase> findByStudentIdentifier(String studentIdentifier);
}