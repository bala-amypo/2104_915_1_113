package com.example.demo.controller;

import com.example.demo.entity.IntegrityCase;
import com.example.demo.service.IntegrityCaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class IntegrityCaseController {

    private final IntegrityCaseService service;

    public IntegrityCaseController(IntegrityCaseService service) {
        this.service = service;
    }

    @PostMapping
    public IntegrityCase create(@RequestBody IntegrityCase integrityCase) {
        return service.save(integrityCase);
    }

    @GetMapping("/student/{studentId}")
    public List<IntegrityCase> getByStudent(@PathVariable String studentId) {
        return service.getByStudent(studentId);
    }
}
