package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Student;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	Optional<Student> findByStudentId(String studentId);
	  Optional<Student> findByUserId(Integer userId); 
	 

	

}
