package com.example.demo.service;
import java.util.List;
import com.example.demo.entity.Marks;

public interface MarksService {
	Marks saveMarks(Marks marks);
    List<Marks> getMarksByStudentId(String studentId);
    List<Marks> getMarksByStudentAndCourse(String studentId, String courseId);

}
