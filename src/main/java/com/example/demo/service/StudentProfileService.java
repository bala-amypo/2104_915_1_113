package com.example.demo.service;

import com.example.demo.entity.StudentProfile;

import java.util.List;

public interface StudentProfileService {

    StudentProfile create(StudentProfile student);

    StudentProfile getById(Long id);

    List<StudentProfile> getAll();
}
