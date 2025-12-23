package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.IntegrityCase;

public interface IntegrityCaseService {

    IntegrityCase createCase(IntegrityCase integrityCase);

    IntegrityCase getCaseById(Long id);

    IntegrityCase updateCaseStatus(Long caseId, String status);

    List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier);

    List<IntegrityCase> getAllCases();
}
