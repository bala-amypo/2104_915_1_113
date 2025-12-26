package com.example.demo.service.impl;

import com.example.demo.entity.StudentProfile;
import com.example.demo.repository.StudentProfileRepository;
import com.example.demo.service.StudentProfileService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentProfileServiceImpl implements StudentProfileService {

    private final StudentProfileRepository repository;

    public StudentProfileServiceImpl(StudentProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    public StudentProfile create(StudentProfile student) {
        return repository.save(student);
    }

    @Override
    public StudentProfile getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public List<StudentProfile> getAll() {
        return repository.findAll();
    }
}
