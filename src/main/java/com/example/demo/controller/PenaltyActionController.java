package com.example.demo.controller;

import com.example.demo.entity.PenaltyAction;
import com.example.demo.service.PenaltyActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/penalties")
public class PenaltyActionController {

    @Autowired
    private PenaltyActionService penaltyActionService;

    @PostMapping
    public ResponseEntity<PenaltyAction> addPenalty(@RequestBody PenaltyAction penalty) {
        PenaltyAction result = penaltyActionService.addPenalty(penalty);
        return ResponseEntity.ok(result);
    }
}
