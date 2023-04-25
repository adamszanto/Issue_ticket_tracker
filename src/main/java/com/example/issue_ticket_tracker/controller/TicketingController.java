package com.example.issue_ticket_tracker.controller;

import com.example.issue_ticket_tracker.service.TicketingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tickets")
public class TicketingController {
    private final Logger logger = LoggerFactory.getLogger(TicketingController.class);
    private final TicketingService ticketingService;

    @Autowired
    public TicketingController(TicketingService ticketingService) {
        this.ticketingService = ticketingService;
    }

    @GetMapping
    public void getTicket() {
        logger.info("- Custom log: Got all tickets");
    }
}
