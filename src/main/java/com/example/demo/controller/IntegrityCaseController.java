package com.example.demo.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;

@RestController
@RequestMapping("/api/integrity-cases")
public class IntegrityCaseController {

    private final IntegrityCaseService integrityCaseService;

    public IntegrityCaseController(IntegrityCaseService integrityCaseService) {
        this.integrityCaseService = integrityCaseService;
    }

    @PostMapping
    public ResponseEntity<IntegrityCase> createCase(@RequestBody IntegrityCase integrityCase) {
        return ResponseEntity.ok(integrityCaseService.createCase(integrityCase));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<IntegrityCase> updateCaseStatus(
            @PathVariable Long id,
            @RequestParam String status) {

        return ResponseEntity.ok(
                integrityCaseService.updateCaseStatus(id, status)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<IntegrityCase> getCaseById(@PathVariable Long id) {
        return ResponseEntity.ok(integrityCaseService.getCaseById(id));
    }

    @GetMapping("/student/{studentProfileId}")
    public ResponseEntity<List<IntegrityCase>> getCasesByStudent(
            @PathVariable Long studentProfileId) {

        return ResponseEntity.ok(
                integrityCaseService.getCasesByStudentIdentifier(studentProfileId)
        );
    }

    @GetMapping
    public ResponseEntity<List<IntegrityCase>> getAllCases() {
        return ResponseEntity.ok(integrityCaseService.getAllCases());
    }
}
