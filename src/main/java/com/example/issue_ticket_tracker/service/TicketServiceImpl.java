package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.mapper.TicketMapper;
import com.example.issue_ticket_tracker.repository.TicketRepository;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    private final Logger logger = LoggerFactory.getLogger(TicketService.class);
    private final TicketRepository ticketRepository;
    private final TicketMapper ticketMapper;

    @Autowired
    public TicketServiceImpl(TicketRepository ticketRepository, TicketMapper ticketMapper) {
        this.ticketRepository = ticketRepository;
        this.ticketMapper = ticketMapper;

    }

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
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTitle(ticket.getTitle());
        ticketEntity.setDetail(ticketMapper.convertDetailModeltoEntity(ticket.getDetail()));
        ticketEntity.setTicketStatusEntity(ticketMapper.convertTicketStatusEntityToModel(ticket.getStatus()));

        TicketEntity savedTicketEntity = ticketRepository.save(ticketEntity);

        return ticketMapper.convertTicketEntitytoModel(savedTicketEntity);
    }

    @Override
    public void updateTicket(Integer ticketId) {

    }

    @Override
    public void deleteTicket(Integer ticketId) {

    }

    @Override
    public TicketDetail getTicketDetails(Integer ticketId) {
        return null;
    }
}
