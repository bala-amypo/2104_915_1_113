package com.example.demo.service;

import com.example.demo.entity.RepeatOffenderRecord;
import com.example.demo.entity.StudentProfile;

public interface StudentProfileService {

    RepeatOffenderRecord evaluate(StudentProfile profile, int cases);
}
