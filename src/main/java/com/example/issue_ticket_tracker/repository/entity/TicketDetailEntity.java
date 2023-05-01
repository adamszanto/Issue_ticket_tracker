package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_detail")
public class TicketDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
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
