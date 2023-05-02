package com.example.issue_ticket_tracker.mapper;

import com.example.issue_ticket_tracker.repository.entity.TicketDetailEntity;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;
import org.springframework.stereotype.Component;

@Component
public class TicketDetailsMapper {

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
}
