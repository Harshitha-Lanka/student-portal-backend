package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Attendance;
import java.util.List;
import java.time.LocalDate;
import org.springframework.data.jpa.repository.Query;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
	List<Attendance> findByStudentIdAndCourseId(String studentId, String courseId);
	 List<Attendance> findByStudentIdAndCourseIdAndDate(String studentId, String courseId, LocalDate date); 
	 List<Attendance> findByStudentId(String studentId);
	 int countByStudentIdAndCourseId(String studentId, String courseId);
	 int countByStudentIdAndCourseIdAndPresentTrue(String studentId, String courseId);
	 @Query("SELECT DISTINCT a.courseId FROM Attendance a WHERE a.studentId = :studentId")
	   List<String> findDistinctCourseIdsByStudentId(String studentId);
	
}
