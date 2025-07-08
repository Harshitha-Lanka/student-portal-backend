package com.example.demo.controller;

import com.example.demo.entity.Enrollment;
import com.example.demo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    // Enroll student (POST)
    @PostMapping
    public ResponseEntity<?> enroll(@RequestBody Map<String, String> payload) {
        String studentId = payload.get("studentId"); // ← ✅ Now a String
        Integer courseId = Integer.parseInt(payload.get("courseId")); // Keep as Integer

        if (studentId == null || courseId == null) {
            return ResponseEntity.badRequest().body("Missing studentId or courseId");
        }

        Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
        return ResponseEntity.ok(enrollment);
    }


    
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollments(@PathVariable String studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }
    @GetMapping("/studentsByCourse/{courseId}")
    public ResponseEntity<List<Map<String, String>>> getStudentsByCourse(@PathVariable String courseId) {
        List<Map<String, String>> students = enrollmentService.getStudentDetailsByCourse(courseId);
        return ResponseEntity.ok(students);
    }
}
