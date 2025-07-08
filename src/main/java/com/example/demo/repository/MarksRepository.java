package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Marks;
import java.util.List;

public interface MarksRepository extends JpaRepository<Marks, Long> {
	 List<Marks> findByStudentId(String studentId);
	    List<Marks> findByStudentIdAndCourseId(String studentId, String courseId);
}
