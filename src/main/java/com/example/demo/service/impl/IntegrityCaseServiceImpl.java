package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.IntegrityCaseService;

@Service
public class IntegrityCaseServiceImpl implements IntegrityCaseService {

    private final IntegrityCaseRepository integrityCaseRepository;

    public IntegrityCaseServiceImpl(IntegrityCaseRepository integrityCaseRepository) {
        this.integrityCaseRepository = integrityCaseRepository;
    }

    @Override
    public IntegrityCase createCase(IntegrityCase integrityCase) {
        return integrityCaseRepository.save(integrityCase);
    }

    @Override
    public IntegrityCase getCaseById(Long id) {
        return integrityCaseRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Integrity case not found with id " + id));
    }

    @Override
    public IntegrityCase updateCaseStatus(Long caseId, String status) {
        IntegrityCase integrityCase = getCaseById(caseId);
        integrityCase.setStatus(status);
        return integrityCaseRepository.save(integrityCase);
    }

    @Override
    public List<IntegrityCase> getCasesByStudentIdentifier(Long studentProfileId) {
        return integrityCaseRepository.findByStudentProfile_Id(studentProfileId);
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return integrityCaseRepository.findAll();
    }
}
