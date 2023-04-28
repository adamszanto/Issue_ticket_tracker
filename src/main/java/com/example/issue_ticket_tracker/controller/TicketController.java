package com.example.issue_ticket_tracker.controller;

import com.example.issue_ticket_tracker.controller.dto.TicketDto;
import com.example.issue_ticket_tracker.mapper.TicketMapper;
import com.example.issue_ticket_tracker.service.TicketServiceImpl;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tickets")
public class TicketController {

    private final Logger logger = LoggerFactory.getLogger(TicketController.class);
    private final TicketServiceImpl ticketServiceImpl;
    private final TicketMapper ticketMapper;
    @Autowired
    public TicketController(TicketServiceImpl ticketServiceImpl, TicketMapper ticketMapper) {
        this.ticketServiceImpl = ticketServiceImpl;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping("")
    public List<Ticket> getAllTickets() {
        logger.info("- Custom log: Got all tickets");
        return ticketServiceImpl.getAllTickets();
    }

    @PostMapping("")
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody TicketDto ticketDto) {
        Ticket ticket = ticketServiceImpl.createTicket(ticketDto.getTicket());
        TicketDto convertedTicket = ticketMapper.convertTicketModelToDto(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertedTicket);
    }

    @GetMapping("/{id}")
    public TicketDetail getTicketDetails(@PathVariable Integer id) {
        return ticketServiceImpl.getTicketDetails(id);
    }

}
