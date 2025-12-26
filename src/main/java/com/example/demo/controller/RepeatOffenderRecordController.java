package com.example.demo.controller;

import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @GetMapping("/{caseId}")
    public String generate(@PathVariable Long caseId) {
        return service.generateRecord(caseId);
    }
}
