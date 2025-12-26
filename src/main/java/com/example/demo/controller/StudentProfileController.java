package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    private final StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }

    @PostMapping
    public StudentProfile create(@RequestBody StudentProfile student) {
        return studentProfileService.createStudent(student);
    }

    @GetMapping("/{id}")
    public StudentProfile getById(@PathVariable Long id) {
        return studentProfileService.getStudentById(id);
    }

    @GetMapping
    public List<StudentProfile> getAll() {
        return studentProfileService.getAllStudents();
    }

    @PutMapping("/{id}/repeat-offender")
    public StudentProfile markRepeatOffender(@PathVariable Long id) {
        return studentProfileService.updateRepeatOffenderStatus(id);
    }
}
