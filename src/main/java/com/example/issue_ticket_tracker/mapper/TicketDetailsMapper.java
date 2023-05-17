package com.example.issue_ticket_tracker.mapper;

import com.example.issue_ticket_tracker.repository.entity.TicketDetailsEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetails;
import org.springframework.stereotype.Component;

@Component
public class TicketDetailsMapper {

    public TicketDetailsEntity convertDetailModeltoEntity(TicketDetails detail, TicketEntity ticketEntity) {
        TicketDetailsEntity ticketDetailsEntity = new TicketDetailsEntity();
        ticketDetailsEntity.setTicketDetailId(detail.getId());
        ticketDetailsEntity.setTicketBody(detail.getTicketBody());
        ticketDetailsEntity.setTicket(ticketEntity);

        return ticketDetailsEntity;
    }

    public TicketDetails convertDetailEntitytoModel(TicketDetailsEntity ticketDetailsEntity) {
        TicketDetails ticketDetails = new TicketDetails();
        ticketDetails.setId(ticketDetailsEntity.getTicketDetailId());
        ticketDetails.setTicketBody(ticketDetailsEntity.getTicketBody());

        return ticketDetails;
    }
}
