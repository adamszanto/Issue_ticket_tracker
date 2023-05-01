package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ticket_status")
public class TicketStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketStatusId;
    @Column(name = "status")
    private String status;

    public Integer getTicketStatusId() {
        return ticketStatusId;
    }

    public void setTicketStatusId(Integer ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
