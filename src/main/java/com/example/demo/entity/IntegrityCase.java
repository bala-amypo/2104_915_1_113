package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "integrity_cases")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntegrityCase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // This field MUST match the repository method name exactly
    private String studentIdentifier;

    private String description;
    private String status;
    private String category;
}