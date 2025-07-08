package com.example.demo.service;
import com.example.demo.entity.Faculty;
import java.util.List;

public interface FacultyService {
	Faculty saveFaculty(Faculty faculty);

    List<Faculty> getAllFaculty();

    Faculty getFacultyById(Integer id);

    Faculty getFacultyByFacultyId(String facultyId);

    Faculty getFacultyByUserId(Integer userId);
	

}
