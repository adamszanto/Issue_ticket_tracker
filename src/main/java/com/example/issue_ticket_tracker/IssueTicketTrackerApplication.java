package com.example.issue_ticket_tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class IssueTicketTrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IssueTicketTrackerApplication.class, args);
    }

}
