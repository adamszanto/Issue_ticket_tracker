package com.example.issue_ticket_tracker.mapper;

import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketStatusEntity;
import com.example.issue_ticket_tracker.service.model.ticket.TicketStatus;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TicketStatusMapper {
    public Set<TicketStatusEntity> convertTicketStatusModelToEntity(Set<TicketStatus> ticketStatus, TicketEntity ticketEntity) {
        return ticketStatus.stream()
                .map(tStatus -> {
                    TicketStatusEntity ticketStatusEntity = new TicketStatusEntity();
                    ticketStatusEntity.setTicketStatusId(tStatus.getTicketStatusId());
                    ticketStatusEntity.setStatus(tStatus.getStatus());
                    ticketStatusEntity.add(ticketEntity);
                    return ticketStatusEntity;
                })
                .collect(Collectors.toSet());
    }

    public Set<TicketStatus> convertTicketStatusEntityToModel(Set<TicketStatusEntity> ticketStatusEntities) {
        return ticketStatusEntities.stream()
                .map(ticketStatusEntity -> {
                    TicketStatus ticketStatus = new TicketStatus();
                    ticketStatus.setStatus(ticketStatusEntity.getStatus());
                    ticketStatus.setTicketStatusId(ticketStatusEntity.getTicketStatusId());
                    return ticketStatus;
                })
                .collect(Collectors.toSet());
    }
}
