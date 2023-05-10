package com.example.issue_ticket_tracker.mapper;

import com.example.issue_ticket_tracker.controller.dto.TicketDto;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    private final TicketDetailsMapper ticketDetailsMapper;
    private final TicketStatusMapper ticketStatusMapper;
    private final TicketEventMapper ticketEventMapper;

    @Autowired
    public TicketMapper(TicketDetailsMapper ticketDetailsMapper, TicketStatusMapper ticketStatusMapper, TicketEventMapper ticketEventMapper) {
        this.ticketDetailsMapper = ticketDetailsMapper;
        this.ticketStatusMapper = ticketStatusMapper;
        this.ticketEventMapper = ticketEventMapper;
    }

    public TicketEntity convertTicketModelToEntity(Ticket ticket) {
        // Ticket alapelemeit állítjuk be
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketId(ticket.getTicketId());
        ticketEntity.setTitle(ticket.getTitle());
        ticketEntity.setPriority(ticket.getPriority());

        // TicketDetail
        if(ticket.getDetail() != null) {
            ticketEntity.setDetail(ticketDetailsMapper.convertDetailModeltoEntity(ticket.getDetail(), ticketEntity));
        }

        // TicketStatus
        if(ticket.getStatus() != null) {
            ticketEntity.setStatus(ticketStatusMapper.convertTicketStatusModelToEntity(ticket.getStatus(), ticketEntity));
        }


        // TicketEvent
        if(ticket.getTicketEvents() != null) {
            ticketEntity.setTicketEvents(ticketEventMapper.convertEventModelToEntity(ticket.getTicketEvents(), ticketEntity));
        }

        return ticketEntity;
    }

    public Ticket convertTicketEntitytoModel(TicketEntity ticketEntity) {
        Ticket ticket = new Ticket();

        ticket.setTicketId(ticketEntity.getTicketId());
        ticket.setTitle(ticketEntity.getTitle());
        ticket.setPriority(ticketEntity.getPriority());

        if(ticketEntity.getDetail() != null) {
            ticket.setDetail(ticketDetailsMapper.convertDetailEntitytoModel(ticketEntity.getDetail()));
        }

        if(ticketEntity.getStatus() != null) {
            ticket.setStatus(ticketStatusMapper.convertTicketStatusEntityToModel(ticketEntity.getStatus()));
        }

        if(ticketEntity.getTicketEvents() != null) {
            ticket.setTicketEvents(ticketEventMapper.convertEventEntityToModel(ticketEntity.getTicketEvents()));
        }
        return ticket;
    }

    public TicketDto convertTicketModelToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicket(ticket);

        return ticketDto;
    }
}
