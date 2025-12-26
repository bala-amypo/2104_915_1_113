package com.example.demo.service;

import com.example.demo.entity.IntegrityCase;
import java.util.List;

public interface IntegrityCaseService {
    IntegrityCase save(IntegrityCase integrityCase);
    List<IntegrityCase> getByStudent(String studentId);
}
