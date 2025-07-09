package com.example.demo.controller;

import com.example.demo.entity.Marks;
import com.example.demo.service.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/marks")
@CrossOrigin(origins = "*")
public class MarksController {

    @Autowired
    private MarksService marksService;

    @PostMapping("/add")
    public ResponseEntity<Marks> addMarks(@RequestBody Marks marks) {
        Marks saved = marksService.saveMarks(marks);
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Marks>> getMarksByStudent(@PathVariable String studentId) {
        return ResponseEntity.ok(marksService.getMarksByStudentId(studentId));
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<List<Marks>> getMarksByCourse(@PathVariable String studentId, @PathVariable String courseId) {
        return ResponseEntity.ok(marksService.getMarksByStudentAndCourse(studentId, courseId));
    }
}