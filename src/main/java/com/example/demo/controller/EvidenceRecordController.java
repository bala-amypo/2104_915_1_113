package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    private final EvidenceRecordService service;

    public EvidenceRecordController(EvidenceRecordService service) {
        this.service = service;
    }

    @PostMapping
    public EvidenceRecord submit(@RequestBody EvidenceRecord evidence) {
        return service.submitEvidence(evidence);
    }
}
