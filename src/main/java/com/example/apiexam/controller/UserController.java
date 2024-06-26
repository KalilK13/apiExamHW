package com.example.apiexam.controller;

import com.example.apiexam.Service.UserService;
import com.example.apiexam.domain.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private UserService userService;
    @PostMapping(value="/users")
    public ResponseEntity<?> createUser(@RequestBody User user){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/users/{userId}")
    public ResponseEntity<?> getUserById(@PathVariable Long userId){
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value="/users")
    public ResponseEntity<?> getAllUsers(){
        userService.getAllUsers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping(value = "/users/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId){
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping(value = "/users/{userId}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable Long userId){
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
