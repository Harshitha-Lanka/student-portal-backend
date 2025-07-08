package com.example.demo.service;

import com.example.demo.entity.Marks;
import com.example.demo.repository.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MarksServiceImpl implements MarksService {

    @Autowired
    private MarksRepository marksRepository;

    @Override
    public Marks saveMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    @Override
    public List<Marks> getMarksByStudentId(String studentId) {
        return marksRepository.findByStudentId(studentId);
    }

    @Override
    public List<Marks> getMarksByStudentAndCourse(String studentId, String courseId) {
        return marksRepository.findByStudentIdAndCourseId(studentId, courseId);
    }
}
