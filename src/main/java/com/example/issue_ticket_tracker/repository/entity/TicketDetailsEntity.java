package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_detail")
public class TicketDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketDetailId;

    @Column(name = "ticket_body")
    private String ticketBody;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "ticket_id", nullable = false)
    private TicketEntity ticket;

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }

    public Integer getTicketDetailId() {
        return ticketDetailId;
    }

    public void setTicketDetailId(Integer ticketDetailEntityId) {
        this.ticketDetailId = ticketDetailEntityId;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }
}
