package com.example.issue_ticket_tracker.repository.entity;

public class TicketDetailsEntity {
    private Integer id;
    private String description;

    public TicketDetailsEntity(Integer id, String description) {
        this.id = id;
        this.description = description;
    }
}
