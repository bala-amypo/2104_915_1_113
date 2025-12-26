package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class IntegrityCase {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private StudentProfile studentProfile;

    private String courseCode;
    private String instructorName;
    private String description;
    private String status = "OPEN";
    private LocalDate incidentDate;
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "integrityCase")
    private List<PenaltyAction> penalties = new ArrayList<>();

    public IntegrityCase() {}

    // getters & setters
}
