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
    public List<IntegrityCase> getCasesByStudentIdentifier(String studentIdentifier) {
        return integrityCaseRepository.findByStudentIdentifier(studentIdentifier);
    }

    @Override
    public List<IntegrityCase> getAllCases() {
        return integrityCaseRepository.findAll();
    }
}
