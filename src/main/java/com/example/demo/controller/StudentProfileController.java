package com.example.demo.controller;

import com.example.demo.entity.StudentProfile;
import com.example.demo.service.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentProfileController {

    @Autowired
    private StudentProfileService studentProfileService;

    @PostMapping
    public ResponseEntity<StudentProfile> createStudent(@RequestBody StudentProfile student) {
        StudentProfile created = studentProfileService.createStudent(student);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentProfile> getStudentById(@PathVariable Long id) {
        StudentProfile student = studentProfileService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @GetMapping
    public ResponseEntity<List<StudentProfile>> getAllStudents() {
        List<StudentProfile> students = studentProfileService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PutMapping("/{id}/update-repeat-offender")
    public ResponseEntity<StudentProfile> updateRepeatOffenderStatus(@PathVariable Long id) {
        StudentProfile updated = studentProfileService.updateRepeatOffenderStatus(id);
        return ResponseEntity.ok(updated);
    }
}
