package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Attendance;
import com.example.demo.repository.AttendanceRepository;
import java.time.LocalDate;

@Service  
public class AttendanceServiceImpl implements AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Override
    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    @Override
    public List<Attendance> getAttendanceByStudentAndCourse(String studentId, String courseId) {
        return attendanceRepository.findByStudentIdAndCourseId(studentId, courseId);
    }
    @Override
    public List<Attendance> getAttendanceByStudentAndCourseAndDate(String studentId, String courseId, LocalDate date) {
        return attendanceRepository.findByStudentIdAndCourseIdAndDate(studentId, courseId, date);
    }
    @Override
    public List<Attendance> getAttendanceByStudent(String studentId) {
        return attendanceRepository.findByStudentId(studentId);
    }
}
