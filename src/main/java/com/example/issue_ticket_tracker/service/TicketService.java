package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.service.model.Ticket;
import com.example.issue_ticket_tracker.service.model.TicketDetails;
import org.springframework.stereotype.Service;

import java.util.List;

public
interface TicketService {
    List<Ticket> getAllTickets();

    Ticket getTicketById(Integer ticketId);
    Ticket createTicket(Ticket ticket);
    void updateTicket(Integer ticketId);
    void deleteTicket(Integer ticketId);
    TicketDetails getTicketDetails(Integer ticketId);
}
