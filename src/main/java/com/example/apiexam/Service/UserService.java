package com.example.apiexam.Service;

import com.example.apiexam.domain.User;
import com.example.apiexam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public void createUser(User user){
        userRepository.save(user);
    }
    public void deleteUser(Long userId){
        userRepository.deleteById(userId);
    }
    public Iterable<User> getAllUsers(){
        return userRepository.findAll();
    }
    public User getUser(Long userId){
        while(getAllUsers().iterator().hasNext()){
            User user = getAllUsers().iterator().next();
            if (user.getId() == userId){
                return user;
            }
        }
        return null;
    }
}
