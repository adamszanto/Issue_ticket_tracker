package com.example.issue_ticket_tracker.validator;

import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.validator.exception.TicketValidationException;

public interface TicketValidator {
    void validate(Ticket ticket) throws TicketValidationException;
}
