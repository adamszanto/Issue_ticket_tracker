package com.example.issue_ticket_tracker.repository.entity;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;
    @Column(name = "body")
    private String body;
    @jakarta.persistence.Id
    private Long id;

    public TicketEntity(Integer ticketId, String body, Long id) {
        this.ticketId = ticketId;
        this.body = body;
        this.id = id;
    }

    public TicketEntity() {
    }
}
