package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Course;
import java.util.List;
import java.util.Optional;
public interface CourseRepository extends JpaRepository<Course, Integer> {
	List<Course> findByFacultyFacultyId(String facultyId);
	 Optional<Course> findById(String id); //

}
