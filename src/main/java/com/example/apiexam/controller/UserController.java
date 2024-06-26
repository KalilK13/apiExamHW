package com.example.apiexam.controller;

import com.example.apiexam.ResourceNotFoundException;
import com.example.apiexam.Service.UserService;
import com.example.apiexam.domain.User;
import com.example.apiexam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @PostMapping(value="/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping(value="/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        verifyUser(userId);
        userService.getUser(userId);
        return  new ResponseEntity<>(userService.getUser(userId), HttpStatus.OK);
    }
    @GetMapping(value="/users")
    public ResponseEntity<?> getAllUsers(){
        userService.getAllUsers();
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        verifyUser(userId);
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/users/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){
        verifyUser(userId);
        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    protected void verifyUser(Long userId) throws ResourceNotFoundException {
        User user = userService.getUser(userId);
        if(user == null) {
            throw new ResourceNotFoundException("User with id " + userId + " not found");
        }
    }
}
