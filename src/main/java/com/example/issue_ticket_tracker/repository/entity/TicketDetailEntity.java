package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.*;

@Entity
public class TicketDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ticket_detail_id")
    private Integer ticketDetailEntityId;

    @Column(name = "ticket_body")
    private String ticketBody;

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }
}
