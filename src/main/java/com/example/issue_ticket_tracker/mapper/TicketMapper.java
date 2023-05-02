package com.example.issue_ticket_tracker.mapper;
import com.example.issue_ticket_tracker.controller.dto.TicketDto;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketStatusEntity;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    private final TicketDetailsMapper ticketDetailsMapper;

    @Autowired
    public TicketMapper(TicketDetailsMapper ticketDetailsMapper) {
        this.ticketDetailsMapper = ticketDetailsMapper;
    }

    public TicketEntity convertTicketModelToEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();

        ticketEntity.setTicketId(ticket.getTicketId());
        ticketEntity.setTitle(ticket.getTitle());
        ticketEntity.setPriority(ticket.getPriority());
        ticketEntity.setDetail(ticketDetailsMapper.convertDetailModeltoEntity(ticket.getDetail()));
        ticketEntity.getDetail().setTicket(ticketEntity);

        //TODO: Ahol a ticketnek valami kapcsolata van, azt oda-vissza be kell állítani mint a 26. sorban...
        return ticketEntity;
    }


    public Ticket convertTicketEntitytoModel(TicketEntity ticketEntity) {
        Ticket ticket = new Ticket();

        ticket.setTicketId(ticketEntity.getTicketId());
        ticket.setTitle(ticketEntity.getTitle());
        ticket.setPriority(ticketEntity.getPriority());
        ticket.setDetail(ticketDetailsMapper.convertDetailEntitytoModel(ticketEntity.getDetail()));

        return ticket;
    }

    public TicketDto convertTicketModelToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicket(ticket);

        return ticketDto;
    }

    public TicketStatusEntity convertTicketStatusModelToEntity(TicketStatus ticketStatus) {
        TicketStatusEntity ticketStatusEntity = new TicketStatusEntity();
        ticketStatusEntity.setTicketStatusId(ticketStatus.getTicketStatusId());
        ticketStatusEntity.setStatus(ticketStatus.getStatus());

        return ticketStatusEntity;
    }

}
