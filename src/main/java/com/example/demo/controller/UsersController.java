package com.example.demo.controller;

import com.example.demo.entity.Users;
import com.example.demo.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Optional;
import java.time.LocalDateTime;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody Users loginUser) {
        List<Users> users = usersService.findAll();

        for (Users user : users) {
            if (user.getEmail().equals(loginUser.getEmail()) &&
                user.getPassword().equals(loginUser.getPassword())) {

                // Return id in the response
                Map<String, Object> response = new HashMap<>();
                response.put("message", "Login successful");
                response.put("role", user.getRole());
                response.put("email", user.getEmail());
                response.put("userId", user.getId()); 

                return ResponseEntity.ok(response);
            }
        }
        

        // Error response
        Map<String, String> error = new HashMap<>();
        error.put("error", "Invalid email or password");
        return ResponseEntity.status(401).body(error);
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> signupUser(@RequestBody Users newUser) {
        List<Users> users = usersService.findAll();

        for (Users existing : users) {
            if (existing.getEmail().equalsIgnoreCase(newUser.getEmail())) {
                Map<String, String> error = new HashMap<>();
                error.put("error", "Email already registered");
                return ResponseEntity.status(400).body(error);
            }
        }

        newUser.setCreated_at(LocalDateTime.now());
        Users savedUser = usersService.saveUser(newUser);

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Signup successful");
        response.put("userId", savedUser.getId());

        return ResponseEntity.ok(response);
    }


    // ✅ UPDATE user
    @PutMapping("/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable Integer id, @RequestBody Users user) {
        user.setId(id); // Set correct ID
        Users updatedUser = usersService.updateUser(user);
        return ResponseEntity.ok(updatedUser);
    }
  
    // ✅ DELETE user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) {
        usersService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }

    // ✅ GET user by ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable Integer id) {
        Optional<Users> user = usersService.findById(id);
        return user.map(ResponseEntity::ok)
                   .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // ✅ GET all users
    @GetMapping
    public ResponseEntity<List<Users>> getAllUsers() {
        List<Users> users = usersService.findAll();
        return ResponseEntity.ok(users);
    }
}
