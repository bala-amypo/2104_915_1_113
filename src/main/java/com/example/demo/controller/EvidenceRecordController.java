package com.example.demo.controller;

import com.example.demo.entity.EvidenceRecord;
import com.example.demo.service.EvidenceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/evidence")
public class EvidenceRecordController {

    @Autowired
    private EvidenceRecordService evidenceRecordService;

    @PostMapping
    public ResponseEntity<EvidenceRecord> submitEvidence(@RequestBody EvidenceRecord evidence) {
        EvidenceRecord saved = evidenceRecordService.submitEvidence(evidence);
        return ResponseEntity.ok(saved);
    }
}
