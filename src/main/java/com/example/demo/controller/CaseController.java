package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseController {
    @Autowired
    private CaseService caseService;

    @GetMapping
    public List<IntegrityCase> getAllCases() {
        return caseService.getAllCases();
    }

    @PostMapping
    public IntegrityCase createCase(@RequestBody IntegrityCase caseRequest) {
        return caseService.createCase(caseRequest);
    }
}
