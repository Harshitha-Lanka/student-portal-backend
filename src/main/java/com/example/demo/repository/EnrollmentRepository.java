package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Enrollment;
import java.util.List;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	 List<Enrollment> findByStudentStudentId(String studentId);
	 List<Enrollment> findByCourseId(String id);
	

}
