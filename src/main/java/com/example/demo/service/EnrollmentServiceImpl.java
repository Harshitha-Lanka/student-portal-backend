package com.example.demo.service;

import com.example.demo.entity.Course;
import com.example.demo.entity.Enrollment;
import com.example.demo.entity.Student;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.EnrollmentRepository;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {

    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
   
    public Enrollment enrollStudent(String studentId, Integer courseId) {
        Student student = studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Course course = courseRepository.findBycourseId(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        // ✅ Check if already enrolled
        Optional<Enrollment> existing = enrollmentRepository.findByStudent_StudentIdAndCourse_CourseId(studentId, courseId);
        if (existing.isPresent()) {
            throw new RuntimeException("Student already enrolled in this course");
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }
    @Override
    public List<Enrollment> getEnrollmentsByStudentId(String studentId) {
        return enrollmentRepository.findByStudentStudentId(studentId);
    }
    @Override
    public List<Map<String, String>> getStudentDetailsByCourse(Integer courseId) {
    	List<Enrollment> enrollments = enrollmentRepository.findByCourse_CourseId(courseId);
        List<Map<String, String>> studentList = new ArrayList<>();

        for (Enrollment e : enrollments) {
            Map<String, String> studentMap = new HashMap<>();
            studentMap.put("studentId", e.getStudent().getStudentId());
            studentMap.put("name", e.getStudent().getName());
            studentList.add(studentMap);
        }
        return studentList;
    }

}
