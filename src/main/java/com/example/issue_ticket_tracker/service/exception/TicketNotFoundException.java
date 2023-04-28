package com.example.issue_ticket_tracker.service.exception;

public class TicketNotFoundException extends RuntimeException {
    // 404
    public TicketNotFoundException(String message) {
        super(message);
    }
}
