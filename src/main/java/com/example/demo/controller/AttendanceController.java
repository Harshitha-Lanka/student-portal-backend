package com.example.demo.controller;

import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.repository.CourseRepository;
import com.example.demo.entity.Course;

import java.util.List;
import java.util.*;

 import com.example.demo.repository.AttendanceRepository;

@RestController
@RequestMapping("/api/attendance")
@CrossOrigin(origins = "*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;
    @Autowired
    private AttendanceRepository attendanceRepository;
    @Autowired
    private CourseRepository courseRepository;

    // ✅ Single entry
    @PostMapping("/mark")
    public ResponseEntity<?> markAttendance(@RequestBody List<Attendance> attendanceList) {
        for (Attendance attendance : attendanceList) {
            List<Attendance> existing = attendanceService.getAttendanceByStudentAndCourseAndDate(
                attendance.getStudentId(),
                attendance.getCourseId(),
                attendance.getDate()
            );

            if (existing.isEmpty()) {
                // Insert new
                attendanceService.saveAttendance(attendance);
            } else {
                // Update existing
                Attendance existingRecord = existing.get(0);
                existingRecord.setPresent(attendance.isPresent());
                attendanceService.saveAttendance(existingRecord);
            }
        }
        return ResponseEntity.ok("✅ Attendance saved or updated successfully.");
    }

   
    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<List<Attendance>> getAttendanceByStudentAndCourse(
            @PathVariable String studentId,
            @PathVariable String courseId
    ) {
        List<Attendance> records = attendanceService.getAttendanceByStudentAndCourse(studentId, courseId);
        return ResponseEntity.ok(records);
    }
    @GetMapping("/percentage/{studentId}")
    public ResponseEntity<List<Map<String, Object>>> getAttendancePercentage(@PathVariable String studentId) {
        List<String> courseIds = attendanceRepository.findDistinctCourseIdsByStudentId(studentId);
        List<Map<String, Object>> result = new ArrayList<>();

        for (String courseId : courseIds) {
            int totalDays = attendanceRepository.countByStudentIdAndCourseId(studentId, courseId);
            int presentDays = attendanceRepository.countByStudentIdAndCourseIdAndPresentTrue(studentId, courseId);
            int percentage = totalDays > 0 ? (presentDays * 100 / totalDays) : 0;

           
            String courseName = courseRepository.findById(courseId)
                    .map(Course::getCourseName)
                    .orElse("Unknown");

            // Put into map
            Map<String, Object> data = new HashMap<>();
            data.put("courseId", courseId);
            data.put("courseName", courseName);
            data.put("totalDays", totalDays);
            data.put("presentDays", presentDays);
            data.put("percentage", percentage);

            result.add(data);
        }

        return ResponseEntity.ok(result);
    }


}
