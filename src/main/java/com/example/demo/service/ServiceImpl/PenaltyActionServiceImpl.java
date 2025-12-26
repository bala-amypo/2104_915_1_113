package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;
import com.example.demo.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PenaltyActionServiceImpl implements PenaltyActionService {

    @Autowired
    private PenaltyActionRepository penaltyActionRepository;

    @Autowired
    private IntegrityCaseRepository integrityCaseRepository;

    @Override
    public PenaltyAction addPenalty(PenaltyAction penalty) {
        IntegrityCase integrityCase = integrityCaseRepository.findById(penalty.getIntegrityCase().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Case not found"));

        // Update case status to UNDER_REVIEW when penalty is added
        integrityCase.setStatus("UNDER_REVIEW");
        integrityCaseRepository.save(integrityCase);

        penalty.setIntegrityCase(integrityCase);
        return penaltyActionRepository.save(penalty);
    }
}
