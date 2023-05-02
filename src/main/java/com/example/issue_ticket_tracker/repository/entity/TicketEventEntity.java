package com.example.issue_ticket_tracker.repository.entity;

import com.example.issue_ticket_tracker.service.model.ticket.TicketEventType;
import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "ticket_event")
public class TicketEventEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketEventId;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "type")
    private TicketEventType type;

    // TODO: Nem teszem bele equals, hashCode, toString-be...
    @ManyToOne(fetch = FetchType.LAZY, cascade = {})
    @JoinColumn(name = "ticket_id")
    private TicketEntity ticket;

    public Integer getTicketEventId() {
        return ticketEventId;
    }

    public void setTicketEventId(Integer ticketEventId) {
        this.ticketEventId = ticketEventId;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public TicketEventType getType() {
        return type;
    }

    public void setType(TicketEventType type) {
        this.type = type;
    }
}
