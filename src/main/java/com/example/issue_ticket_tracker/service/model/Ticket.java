package com.example.issue_ticket_tracker.service.model;

import com.example.issue_ticket_tracker.repository.entity.TicketEntity;

import java.util.List;
import java.util.Objects;

public class Ticket {
    private Integer ticketId;
    private String title;
    private TicketDetails detail;
    private TicketStatus status;
    private List<TicketEvent> ticketEvents;
    // private enum Priority
    // Spring Security után...: JWT token-es
    // private User creater
    // private User assignee

    public Ticket(Integer ticketId, String title, TicketStatus status) {
        this.ticketId = ticketId;
        this.title = title;
        this.status = status;
    }

    public Ticket() {
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

    public void setTitle(String title) {
        this.title = title;
    }

    public TicketStatus getStatus() {
        return status;
    }

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (!Objects.equals(ticketId, ticket.ticketId)) return false;
        if (!Objects.equals(title, ticket.title)) return false;
        return status == ticket.status;
    }

    @Override
    public int hashCode() {
        int result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", title='" + title + '\'' +
                ", status=" + status +
                '}';
    }
}
