package com.example.issue_ticket_tracker.controller.dto;

import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import jakarta.validation.constraints.NotNull;

public class TicketDto {
    @NotNull
    private Ticket ticket;

    public TicketDto() {
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
