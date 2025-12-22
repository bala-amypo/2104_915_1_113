package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyActionController {

    private final PenaltyActionService service;

    public PenaltyActionController(PenaltyActionService service) {
        this.service = service;
    }

    @PostMapping
    public PenaltyAction addPenalty(@RequestBody PenaltyAction penalty) {
        return service.addPenalty(penalty);
    }
}
