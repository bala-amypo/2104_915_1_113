package com.example.demo.controller;

import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService service;

    public RepeatOffenderRecordController(RepeatOffenderRecordService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public String generate(@PathVariable Long id) {
        return service.generateRecord(id);
    }
}
