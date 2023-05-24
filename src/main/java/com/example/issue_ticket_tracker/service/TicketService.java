package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.mapper.TicketMapper;
import com.example.issue_ticket_tracker.repository.TicketRepository;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketEventEntity;
import com.example.issue_ticket_tracker.service.exception.TicketNotFoundException;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetails;
import com.example.issue_ticket_tracker.service.model.ticket.TicketEventType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketService {

    private final Logger logger = LoggerFactory.getLogger(TicketService.class);
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll().stream()
                .map(ticketEntity -> ticketMapper.convertTicketEntitytoModel(ticketEntity))
                .collect(Collectors.toList());
    }

    public Ticket getTicketById(Integer ticketId) {
        TicketEntity ticketEntity = ticketRepository.findById(ticketId)
                .orElseThrow(() -> new TicketNotFoundException("Ticket with given id is not found."));
        return ticketMapper.convertTicketEntitytoModel(ticketEntity);

    }

    public Ticket createTicket(Ticket ticket) {
        TicketEntity ticketEntity = ticketMapper.convertTicketModelToEntity(ticket);

        TicketEventEntity updatedEvent = new TicketEventEntity();
        updatedEvent.setType(TicketEventType.CREATED);
        updatedEvent.setTicket(ticketEntity);
        ticketEntity.add(updatedEvent);

        TicketEntity savedTicketEntity = ticketRepository.save(ticketEntity);
        return ticketMapper.convertTicketEntitytoModel(savedTicketEntity);
    }

    public Ticket patchTicket(Ticket ticket) {
        TicketEntity storedTicket = ticketRepository.findById(ticket.getTicketId())
                .orElseThrow(() -> new TicketNotFoundException("Ticket with given id is not found."));

        ticketMapper.patchTicketEntityByTicket(storedTicket, ticket);
        return ticketMapper.convertTicketEntitytoModel(ticketRepository.save(storedTicket));

    }

    public boolean deleteTicket(Integer ticketId) {
        try {
            ticketRepository.deleteById(ticketId);
            return true;
        } catch (TicketNotFoundException e) {
            return false;
        }
    }

    public TicketDetails getTicketDetails(Integer ticketId) {
        return null;
    }
}
