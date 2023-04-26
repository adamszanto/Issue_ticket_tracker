package com.example.issue_ticket_tracker.controller;

import com.example.issue_ticket_tracker.service.TicketServiceImpl;
import com.example.issue_ticket_tracker.service.model.Ticket;
import com.example.issue_ticket_tracker.service.model.TicketDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {
    private final Logger logger = LoggerFactory.getLogger(TicketController.class);
    @Autowired
    private TicketServiceImpl ticketServiceImpl;
    public TicketController(TicketServiceImpl ticketServiceImpl) {
        this.ticketServiceImpl = ticketServiceImpl;
    }

    @GetMapping("")
    public List<Ticket> getAllTickets() {
        logger.info("- Custom log: Got all tickets");
        return ticketServiceImpl.getAllTickets();
    }

    @PostMapping("")
    public Ticket createTicket(@RequestBody Ticket ticket) {
        return ticketServiceImpl.createTicket(ticket);
    }

    @GetMapping("/{id}")
    public TicketDetails getTicketDetails(@PathVariable Integer id) {
        return ticketServiceImpl.getTicketDetails(id);
    }
}
