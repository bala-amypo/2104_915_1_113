package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class PenaltyAction {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private IntegrityCase integrityCase;

    private String penaltyType;
    private String details;
    private String issuedBy;
    private LocalDateTime issuedAt = LocalDateTime.now();

    public PenaltyAction() {}

    // getters & setters
}
