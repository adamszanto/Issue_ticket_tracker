package com.example.issue_ticket_tracker.service.model.ticket;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

public class TicketDetail {
    private String ticketBody;

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }
}
