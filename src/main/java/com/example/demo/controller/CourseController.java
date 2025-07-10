package com.example.demo.controller;

import com.example.demo.entity.Course;
import com.example.demo.entity.Faculty;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin(origins = "*")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private FacultyRepository facultyRepository;

    // ✅ Faculty adds a course
    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
    	if (course.getCourseCode() == null || course.getCourseCode().isBlank()) {
    	    return ResponseEntity.badRequest().body("Course Code is required");
    	}
        if (course.getFaculty() == null || course.getFaculty().getFacultyId() == null) {
            return ResponseEntity.badRequest().body("Faculty ID is required");
        }

        // ✅ updated to match String
        Faculty faculty = facultyRepository.findByFacultyId(course.getFaculty().getFacultyId())
                .orElseThrow(() -> new RuntimeException("Faculty not found"));

        course.setFaculty(faculty);
        Course savedCourse = courseService.saveCourse(course);
        return ResponseEntity.ok(savedCourse);
    }


    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
   
    @GetMapping("/byFacultyId/{facultyId}")
    public List<Course> getCoursesByFaculty(@PathVariable String facultyId) {
        return courseService.getCoursesByFacultyId(facultyId);
    }
}
