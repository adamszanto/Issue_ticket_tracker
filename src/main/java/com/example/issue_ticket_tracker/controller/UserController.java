package com.example.issue_ticket_tracker.controller;

import com.example.issue_ticket_tracker.controller.dto.UserDto;
import com.example.issue_ticket_tracker.service.UserServiceImpl;
import com.example.issue_ticket_tracker.service.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserServiceImpl userServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userDto) {
        return null;
    }
}
