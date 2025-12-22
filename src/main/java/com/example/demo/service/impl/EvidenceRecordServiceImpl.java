package com.example.demo.service.impl;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.EvidenceRecordRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.EvidenceRecordService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EvidenceRecordServiceImpl implements EvidenceRecordService {

    @Autowired
    private EvidenceRecordRepository evidenceRecordRepository;

    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;

    @Override
    public EvidenceRecord submitEvidence(EvidenceRecord evidence) {
        IntegrityCase integrityCase = integrityCaseRepository.findById(evidence.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Case not found"));
        evidence.setIntegrityCase(integrityCase);
        return evidenceRecordRepository.save(evidence);
    }
}
