package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Faculty;
import com.example.demo.entity.Users;
import com.example.demo.repository.FacultyRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyServiceImpl implements FacultyService {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        if (faculty.getUser() != null) {
            Integer userId = faculty.getUser().getId();
            Users existingUser = usersRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
            faculty.setUser(existingUser); // attach a managed user entity
        }
        return facultyRepository.save(faculty);
    }

    @Override
    public List<Faculty> getAllFaculty() {
        return facultyRepository.findAll();
    }

    @Override
    public Faculty getFacultyById(Integer id) {
        return facultyRepository.findById(id).orElse(null);
    }

    @Override
    public Faculty getFacultyByFacultyId(String facultyId) {
        return facultyRepository.findByFacultyId(facultyId).orElse(null);
    }

    @Override
    public Faculty getFacultyByUserId(Integer userId) {
        return facultyRepository.findByUser_Id(userId).orElse(null); // ✅
    }
}
