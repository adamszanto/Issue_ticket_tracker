package com.example.issue_ticket_tracker.mapper;

import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketEventEntity;
import com.example.issue_ticket_tracker.service.model.ticket.TicketEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketEventMapper {

    public List<TicketEventEntity> convertEventModelToEntity(List<TicketEvent> ticketEvents, TicketEntity ticketEntity) {

        return ticketEvents.stream()
                .map(ticketEvent -> {
                    TicketEventEntity ticketEventEntity = new TicketEventEntity();
                    ticketEventEntity.setTicketEventId(ticketEvent.getId());
                    ticketEventEntity.setCreatedAt(ticketEvent.getCreatedAt());
                    ticketEventEntity.setType(ticketEvent.getType());
                    ticketEventEntity.setTicket(ticketEntity);
                    return ticketEventEntity;
                })
                .collect(Collectors.toList());
    }

    public List<TicketEvent> convertEventEntityToModel(List<TicketEventEntity> ticketEventEntities) {
        return ticketEventEntities.stream()
                .map(ticketEventEntity -> {
                    TicketEvent ticketEvent = new TicketEvent();
                    ticketEvent.setId(ticketEvent.getId());
                    ticketEvent.setCreatedAt(ticketEvent.getCreatedAt());
                    ticketEvent.setType(ticketEvent.getType());
                    return ticketEvent;

                })
                .collect(Collectors.toList());
    }
}
