package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "integrity_case")
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String studentIdentifier;

    private String caseDescription;

    private String status;

    public IntegrityCase() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentIdentifier() {
        return studentIdentifier;
    }

    public void setStudentIdentifier(String studentIdentifier) {
        this.studentIdentifier = studentIdentifier;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
