package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Faculty;
import java.util.Optional;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {
       Optional<Faculty> findByFacultyId(String facultyId);
       Optional<Faculty> findByUser_Id(Integer userId);

}
