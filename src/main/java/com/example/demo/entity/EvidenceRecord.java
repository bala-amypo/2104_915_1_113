package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class EvidenceRecord {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private IntegrityCase integrityCase;

    private String evidenceType;
    private String content;
    private String submittedBy;
    private LocalDateTime submittedAt = LocalDateTime.now();

    public EvidenceRecord() {}

    // getters & setters
}
