package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {

    @Autowired
    private IntegrityCaseService integrityCaseService;

    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase integrityCase) {
        IntegrityCase created = integrityCaseService.createCase(integrityCase);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(@PathVariable Long id, @RequestParam String status) {
        IntegrityCase updated = integrityCaseService.updateCaseStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(@PathVariable Long studentId) {
        List<IntegrityCase> cases = integrityCaseService.getCasesByStudent(studentId);
        return ResponseEntity.ok(cases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<IntegrityCase>> getCaseById(@PathVariable Long id) {
        Optional<IntegrityCase> caseOpt = integrityCaseService.getCaseById(id);
        return ResponseEntity.ok(caseOpt);
    }
}
