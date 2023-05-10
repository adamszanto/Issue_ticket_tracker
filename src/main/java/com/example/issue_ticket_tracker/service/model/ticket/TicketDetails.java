package com.example.issue_ticket_tracker.service.model.ticket;

public class TicketDetails {
    private Integer id;
    private String ticketBody;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTicketBody() {
        return ticketBody;
    }

    public void setTicketBody(String ticketBody) {
        this.ticketBody = ticketBody;
    }
}
