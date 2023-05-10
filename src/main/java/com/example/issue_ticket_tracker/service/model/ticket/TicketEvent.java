package com.example.issue_ticket_tracker.service.model.ticket;

import java.time.Instant;

public class TicketEvent {
    private Integer id;
    private Instant createdAt;
    private TicketEventType type;
    // private String customDetailInfo

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TicketEventType getType() {
        return type;
    }

    public void setType(TicketEventType type) {
        this.type = type;
    }

    public TicketEvent() {
        this.createdAt = createdAt;
    }
}
