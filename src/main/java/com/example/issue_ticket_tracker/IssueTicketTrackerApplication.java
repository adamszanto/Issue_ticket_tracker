package com.example.issue_ticket_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.issue_ticket_tracker.repository")
public class IssueTicketTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueTicketTrackerApplication.class, args);
    }

}
