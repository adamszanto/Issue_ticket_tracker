package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;

import java.util.List;

public
interface TicketService {
    List<Ticket> getAllTickets();

    Ticket getTicketById(Integer ticketId);
    Ticket createTicket(Ticket ticket);
    void updateTicket(Integer ticketId);
    void deleteTicket(Integer ticketId);
    TicketDetail getTicketDetails(Integer ticketId);
}
