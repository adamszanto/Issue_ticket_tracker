package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.service.exception.TicketNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TicketServiceImpl implements TicketService {
    private final Logger logger = LoggerFactory.getLogger(TicketService.class);

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public void updateTicket(Integer ticketId) {
        Ticket existingTicket = ticketRepository.findById(ticketId).orElseThrow(() -> new TicketNotFoundException(ticketId));
        existingTicket.setTitle(ticket().getTitle());
        existingTicket.setStatus(ticket.getStatus());
        return ticketRepository.save(existingTicket);
    }

    @Override
    public void deleteTicket(Integer ticketId) {
        ticketRepository.deleteById(ticket);
    }

    @Override
    public TicketDetails getTicketDetailsById(Integer ticketId) {
        Ticket ticket = ticketRepository.findById(id).orElseThrow(() -> new TicketNotFoundException(ticketId));
        TicketDetails ticketDetails = ticketDetailsRepository.findByTicketId(ticket.getId());
    }
}
