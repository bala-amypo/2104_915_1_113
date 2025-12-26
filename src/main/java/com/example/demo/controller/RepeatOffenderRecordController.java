package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import com.example.demo.service.RepeatOffenderRecordService;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String generateRecord(@PathVariable Long id) {
        return service.generateRecord(id);
    }
}
