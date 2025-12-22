package com.example.demo.controller;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.service.RepeatOffenderRecordService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/repeat-offenders")
public class RepeatOffenderRecordController {

    private final RepeatOffenderRecordService repeatOffenderRecordService;

    public RepeatOffenderRecordController(RepeatOffenderRecordService repeatOffenderRecordService) {
        this.repeatOffenderRecordService = repeatOffenderRecordService;
    }

    @PostMapping("/{studentId}")
    public RepeatOffenderRecord calculateRepeatOffender(@PathVariable Long studentId) {
        return repeatOffenderRecordService.processRepeatOffender(studentId);
    }

    @GetMapping("/{studentId}")
    public RepeatOffenderRecord getRepeatOffender(@PathVariable Long studentId) {
        return repeatOffenderRecordService.getByStudentId(studentId);
    }
}
