package com.example.demo.service;
import com.example.demo.entity.Attendance;
import java.util.*;
import java.time.LocalDate;
public interface AttendanceService {
	 Attendance saveAttendance(Attendance attendance);
	    List<Attendance> getAttendanceByStudentAndCourse(String studentId, String courseId);
	    List<Attendance> getAttendanceByStudentAndCourseAndDate(String studentId, String courseId, LocalDate date);
	    List<Attendance> getAttendanceByStudent(String studentId);

}
