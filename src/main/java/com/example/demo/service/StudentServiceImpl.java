package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.entity.Users;
import com.example.demo.repository.StudentRepository;
import com.example.demo.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UsersRepository userRepository;

    @Override
    public Student saveStudent(Student student) {
        Integer userId = student.getUser().getId();

        Users existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        student.setUser(existingUser);
        return studentRepository.save(student);
    }

   
    @Override
    public Student getStudentById(Integer id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
    }
    @Override
    public Student getStudentByStudentId(String studentId) {
        return studentRepository.findByStudentId(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found with studentId: " + studentId));
    }

    @Override
    public Student getStudentByUserId(Integer userId) {
        return studentRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Student not found for userId: " + userId));
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
