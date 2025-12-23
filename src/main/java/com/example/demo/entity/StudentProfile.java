package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "studentProfile", cascade = CascadeType.ALL)
    private List<IntegrityCase> integrityCases;

    // getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<IntegrityCase> getIntegrityCases() {
        return integrityCases;
    }

    public void setIntegrityCases(List<IntegrityCase> integrityCases) {
        this.integrityCases = integrityCases;
    }
}
