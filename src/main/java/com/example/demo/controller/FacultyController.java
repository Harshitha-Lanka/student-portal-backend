package com.example.demo.controller;

import com.example.demo.entity.Faculty;
import com.example.demo.service.FacultyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/faculty")
public class FacultyController {

    @Autowired
    private FacultyService facultyService;

    // POST: Save faculty registration
    @PostMapping
    public ResponseEntity<Faculty> saveFaculty(@RequestBody Faculty faculty) {
        Faculty savedFaculty = facultyService.saveFaculty(faculty);
        return ResponseEntity.ok(savedFaculty);
    }

    // GET: All faculty
    @GetMapping
    public ResponseEntity<List<Faculty>> getAllFaculty() {
        return ResponseEntity.ok(facultyService.getAllFaculty());
    }

    // GET: Faculty by ID
    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable Integer id) {
        Faculty faculty = facultyService.getFacultyById(id);
        return faculty != null ? ResponseEntity.ok(faculty) : ResponseEntity.notFound().build();
    }

    // GET: Faculty by FacultyId
    @GetMapping("/byFacultyId/{facultyId}")
    public ResponseEntity<Faculty> getByFacultyId(@PathVariable String facultyId) {
        Faculty faculty = facultyService.getFacultyByFacultyId(facultyId);
        return faculty != null ? ResponseEntity.ok(faculty) : ResponseEntity.notFound().build();
    }

    // GET: Faculty by UserId (for post-login check)
    @GetMapping("/byUserId/{userId}")
    public ResponseEntity<Faculty> getByUserId(@PathVariable Integer userId) {
        Faculty faculty = facultyService.getFacultyByUserId(userId);
        return faculty != null ? ResponseEntity.ok(faculty) : ResponseEntity.notFound().build();
    }
}
