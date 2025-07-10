package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Enrollment;
import java.util.*;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudentStudentId(String studentId);
    List<Enrollment> findByCourse_CourseId(Integer courseId);
    Optional<Enrollment> findByStudent_StudentIdAndCourse_CourseId(String studentId, Integer courseId); // new method
}
