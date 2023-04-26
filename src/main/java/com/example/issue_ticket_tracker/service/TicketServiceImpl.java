package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.service.exception.TicketNotFoundException;
import com.example.issue_ticket_tracker.service.model.Ticket;
import com.example.issue_ticket_tracker.service.model.TicketDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {
    private final Logger logger = LoggerFactory.getLogger(TicketService.class);


    @Override
    public List<Ticket> getAllTickets() {
        return null;
    }

    @Override
    public Ticket getTicketById(Integer ticketId) {
        return null;
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return null;
    }

    @Override
    public void updateTicket(Integer ticketId) {

    }

    @Override
    public void deleteTicket(Integer ticketId) {

    }

    @Override
    public TicketDetails getTicketDetails(Integer ticketId) {
        return null;
    }
}
