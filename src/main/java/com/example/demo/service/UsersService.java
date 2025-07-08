package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.Users;

public interface UsersService {
    
    Users saveUser(Users user);                      // Save a user
    Users updateUser(Users user);                    // Update a user
    void deleteUser(Integer id);    // Delete user by ID
    
    Optional<Users> findById(Integer id);            // Find user by ID
    List<Users> findAll();       
   
}
