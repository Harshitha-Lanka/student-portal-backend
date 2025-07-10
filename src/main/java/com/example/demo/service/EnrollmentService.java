package com.example.demo.service;

import com.example.demo.entity.Enrollment;
import java.util.List;

import java.util.Map;
public interface EnrollmentService {
    Enrollment enrollStudent(String studentId, Integer courseId);
    List<Enrollment> getEnrollmentsByStudentId(String studentId);
    List<Map<String, String>> getStudentDetailsByCourse(Integer courseId);
    
}
