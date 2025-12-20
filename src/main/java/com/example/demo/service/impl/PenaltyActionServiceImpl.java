package com.example.demo.service.impl;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.entity.IntegrityCase;
import com.example.demo.repository.PenaltyActionRepository;
import com.example.demo.repository.IntegrityCaseRepository;
import com.example.demo.service.PenaltyActionService;

public class PenaltyActionServiceImpl implements PenaltyActionService {

    private final PenaltyActionRepository penaltyRepo;
    private final IntegrityCaseRepository caseRepo;

    public PenaltyActionServiceImpl(
            PenaltyActionRepository penaltyRepo,
            IntegrityCaseRepository caseRepo
    ) {
        this.penaltyRepo = penaltyRepo;
        this.caseRepo = caseRepo;
    }

    @Override
    public PenaltyAction addPenalty(PenaltyAction penaltyAction) {
        IntegrityCase c = caseRepo.findById(
                penaltyAction.getIntegrityCase().getId()
        ).orElseThrow(() -> new IllegalArgumentException("Case not found"));

        c.setStatus("UNDER_REVIEW");
        caseRepo.save(c);

        penaltyAction.setIntegrityCase(c);
        return penaltyRepo.save(penaltyAction);
    }
}
