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
    public StudentProfile createStudent(@RequestBody StudentProfile studentProfile) {
        return studentProfileService.createStudent(studentProfile);
    }

    @GetMapping
    public List<StudentProfile> getAllStudents() {
        return studentProfileService.getAllStudents();
    }

    @GetMapping("/{id}")
    public StudentProfile getStudentById(@PathVariable Long id) {
        return studentProfileService.getStudentById(id);
    }

    @PutMapping("/{id}/repeat-offender")
    public StudentProfile updateRepeatOffenderStatus(@PathVariable Long id) {
        return studentProfileService.updateRepeatOffenderStatus(id);
    }
}
