package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_detail")
public class TicketDetailsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketDetailEntityId;

    @Column(name = "ticket_body")
    private String ticketBody;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId")
    private TicketEntity ticket;

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }

    public Integer getTicketDetailEntityId() {
        return ticketDetailEntityId;
    }

    public void setTicketDetailEntityId(Integer ticketDetailEntityId) {
        this.ticketDetailEntityId = ticketDetailEntityId;
    }

    public TicketEntity getTicket() {
        return ticket;
    }

    public void setTicket(TicketEntity ticket) {
        this.ticket = ticket;
    }
}
