package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class StudentProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private boolean repeatOffender;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isRepeatOffender() {
        return repeatOffender;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRepeatOffender(boolean repeatOffender) {
        this.repeatOffender = repeatOffender;
    }
}
