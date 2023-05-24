package com.example.issue_ticket_tracker.controller;

import com.example.issue_ticket_tracker.controller.dto.TicketDto;
import com.example.issue_ticket_tracker.mapper.TicketMapper;
import com.example.issue_ticket_tracker.service.TicketService;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetails;
import com.example.issue_ticket_tracker.validator.NewTicketValidator;
import com.example.issue_ticket_tracker.validator.PatchTicketValidator;
import com.example.issue_ticket_tracker.validator.exception.TicketValidationException;
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
    private final NewTicketValidator newTicketValidator;
    private final PatchTicketValidator patchTicketValidator;
    private final TicketService ticketService;
    private final TicketMapper ticketMapper;
    @Autowired
    public TicketController(NewTicketValidator newTicketValidator, PatchTicketValidator patchTicketValidator, TicketService ticketService, TicketMapper ticketMapper) {
        this.newTicketValidator = newTicketValidator;
        this.patchTicketValidator = patchTicketValidator;
        this.ticketService = ticketService;
        this.ticketMapper = ticketMapper;
    }

    @GetMapping
    public List<Ticket> getAllTickets() {
        logger.info("- Custom log: Got all tickets");
        return ticketService.getAllTickets();
    }


    @PostMapping
    public ResponseEntity<TicketDto> createTicket(@Valid @RequestBody TicketDto ticketDto) {
        try {
            newTicketValidator.validate(ticketDto.getTicket());
        } catch (TicketValidationException e) {
            logger.warn("Exception occurred while creating a new ticket: ", e);
            return ResponseEntity.badRequest().build();
        }
        Ticket ticket = ticketService.createTicket(ticketDto.getTicket());
        TicketDto convertedTicket = ticketMapper.convertTicketModelToDto(ticket);
        return ResponseEntity.status(HttpStatus.CREATED).body(convertedTicket);
    }

    @PatchMapping
    public ResponseEntity<TicketDto> patchTicket(@Valid @RequestBody TicketDto ticketDto) {
        try {
            patchTicketValidator.validate(ticketDto.getTicket());
        } catch (TicketValidationException e) {
            logger.warn("", e);
            return ResponseEntity.badRequest().build();
        }

        Ticket ticket = ticketService.patchTicket(ticketDto.getTicket());
        TicketDto convertedTicket = ticketMapper.convertTicketModelToDto(ticket);
        return ResponseEntity.ok(convertedTicket);
    }

    @GetMapping("/{id}")
    public TicketDetails getTicketDetails(@PathVariable Integer id) {
        return ticketService.getTicketDetails(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteTicket(@PathVariable Integer id) {
        boolean deleted = ticketService.deleteTicket(id);

        if(!deleted) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
