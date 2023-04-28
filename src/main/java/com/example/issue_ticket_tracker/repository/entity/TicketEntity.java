package com.example.issue_ticket_tracker.repository.entity;


import com.example.issue_ticket_tracker.service.model.TicketStatus;
import jakarta.persistence.*;

import java.util.Objects;

// spring-boot-starter-data-jpa

@Entity
@Table(name = "tickets")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer ticketId;
    @Column(name = "body")
    private String title;
    private TicketStatus status;

    public TicketEntity(Integer ticketId, String title, TicketStatus status) {
        this.ticketId = ticketId;
        this.title = title;
        this.status = status;
    }

    public TicketEntity() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String body) {
        this.title = body;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (!Objects.equals(ticketId, that.ticketId)) return false;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        int result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
