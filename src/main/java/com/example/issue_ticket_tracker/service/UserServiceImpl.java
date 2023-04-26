package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.repository.UserRepository;
import com.example.issue_ticket_tracker.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl {

    @Autowired
    private UserRepository userRepository;

    public User login() {
        return null;
    }
}
