package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class TicketDetailEntity {
    @Id

    @Column(name="ticket_detail_id")
    private String ticketBody;

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }
}
