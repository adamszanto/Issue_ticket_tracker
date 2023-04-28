package com.example.issue_ticket_tracker.service.model;

import java.time.Instant;

public class TicketEvent {
    private final Instant createdAt;
    private TicketEventType type;
    // private String customDetailInfo
    public TicketEvent(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
