package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Notice;
import java.util.List;

public interface NoticeRepository extends JpaRepository<Notice, Integer> {
	 List<Notice> findByFacultyFacultyId(String facultyId);

}
