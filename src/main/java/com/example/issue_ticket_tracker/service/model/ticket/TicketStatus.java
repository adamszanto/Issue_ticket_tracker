package com.example.issue_ticket_tracker.service.model.ticket;

public class TicketStatus {
    private Integer ticketStatusId;
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