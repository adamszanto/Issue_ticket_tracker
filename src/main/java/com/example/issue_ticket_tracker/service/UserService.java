package com.example.issue_ticket_tracker.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;

interface UserService {

    public User login();
}
