package com.example.issue_ticket_tracker.controller;

import com.example.issue_ticket_tracker.service.TicketService;
import com.example.issue_ticket_tracker.service.TicketingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tickets")
public class TicketController {
    private final Logger logger = LoggerFactory.getLogger(TicketController.class);
    @Autowired
    private TicketService ticketService;
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("")
    public List<Ticket> getAllTickets() {
        logger.info("- Custom log: Got all tickets");
        return ticketService.getAllTickets();
    }

    @PostMapping("")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public TicketDetails getTicketDetails(@PathVariable Integer id) {
        return ticketService.getTicketDetails(id);
    }
}
