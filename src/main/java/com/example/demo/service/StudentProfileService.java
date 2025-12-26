package com.example.demo.service;

import com.example.demo.entity.StudentProfile;
import java.util.List;

public interface StudentProfileService {
    // Add these three methods
    StudentProfile create(StudentProfile profile);
    StudentProfile getById(Long id);
    List<StudentProfile> getAll();
}