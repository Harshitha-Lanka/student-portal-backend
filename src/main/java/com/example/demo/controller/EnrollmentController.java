package com.example.demo.controller;

import com.example.demo.entity.Enrollment;
import com.example.demo.service.EnrollmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.lang.NumberFormatException;


@RestController
@RequestMapping("/api/enrollments")
@CrossOrigin(origins = "*")
public class EnrollmentController {

    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public ResponseEntity<?> enroll(@RequestBody Map<String, String> payload) {
        String studentId = payload.get("studentId");
        String courseIdStr = payload.get("courseId");

        if (studentId == null || courseIdStr == null) {
            return ResponseEntity.badRequest().body("Missing studentId or courseId");
        }

        try {
            Integer courseId = Integer.parseInt(courseIdStr);
            Enrollment enrollment = enrollmentService.enrollStudent(studentId, courseId);
            return ResponseEntity.ok(enrollment);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body("Invalid courseId format");
        } catch (RuntimeException ex) {
            return ResponseEntity.status(409).body(ex.getMessage());  // 409 = Conflict
        }
    }



    
    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollments(@PathVariable String studentId) {
        return enrollmentService.getEnrollmentsByStudentId(studentId);
    }
    @GetMapping("/studentsByCourse/{courseId}")
    public ResponseEntity<List<Map<String, String>>> getStudentsByCourse(@PathVariable Integer courseId) {
        List<Map<String, String>> students = enrollmentService.getStudentDetailsByCourse(courseId);
        return ResponseEntity.ok(students);
    }
}
