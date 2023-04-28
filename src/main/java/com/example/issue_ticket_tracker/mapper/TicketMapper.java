package com.example.issue_ticket_tracker.mapper;

import com.example.issue_ticket_tracker.controller.dto.TicketDto;
import com.example.issue_ticket_tracker.repository.entity.TicketDetailEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketEventEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketStatusEntity;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;
import com.example.issue_ticket_tracker.service.model.ticket.TicketStatus;
import org.springframework.stereotype.Component;

@Component
public class TicketMapper {
    public TicketEntity convertTicketModelToEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();

        ticketEntity.setTicketId(ticket.getTicketId());
        ticketEntity.setTitle(ticket.getTitle());
        ticketEntity.setPriority(ticket.getPriority());
        ticketEntity.setDetail(convertDetailModeltoEntity(ticket.getDetail()));

        return ticketEntity;
    }

    public TicketDetailEntity convertDetailModeltoEntity(TicketDetail detail) {
        TicketDetailEntity ticketDetailEntity = new TicketDetailEntity();
        ticketDetailEntity.setTicketBody(detail.getTicketBody());

        return ticketDetailEntity;
    }

    public TicketDetail convertDetailEntitytoModel(TicketDetailEntity ticketDetailEntity) {
        TicketDetail ticketDetail = new TicketDetail();
        ticketDetail.setTicketBody(ticketDetailEntity.getTicketBody());

        return ticketDetail;
    }

    public Ticket convertTicketEntitytoModel(TicketEntity ticketEntity) {
        Ticket ticket = new Ticket();

        ticket.setTicketId(ticketEntity.getTicketId());
        ticket.setTitle(ticketEntity.getTitle());
        ticket.setPriority(ticketEntity.getPriority());
        ticket.setDetail(convertDetailEntitytoModel(ticketEntity.getDetail()));

        return ticket;
    }

    public TicketDto convertTicketModelToDto(Ticket ticket) {
        TicketDto ticketDto = new TicketDto();
        ticketDto.setTicket(ticket);

        return ticketDto;
    }

    public TicketStatusEntity convertTicketStatusEntityToModel(TicketStatus ticketStatus) {
        TicketStatusEntity ticketStatusEntity = new TicketStatusEntity();
        ticketStatusEntity.setTicketStatusId(ticketStatus.getTicketStatusId());
        ticketStatusEntity.setStatus(ticketStatus.getStatus());

        return ticketStatusEntity;
    }

}
