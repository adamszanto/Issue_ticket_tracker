package com.example.issue_ticket_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(UserLoginDto userLoginDto) {
        User user = userRepository.findByUsername(userLoginDto.getUserName());
        if(user != null && user.getPassword().equals(userLoginDto.getPassword())) {
            return user;
        } else {
            return null;
        }
    }
}
