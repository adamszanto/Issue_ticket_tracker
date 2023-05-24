package com.example.issue_ticket_tracker.validator;

import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.validator.exception.TicketValidationException;
import org.springframework.stereotype.Component;

@Component
public class NewTicketValidator implements TicketValidator {

    @Override
    public void validate(Ticket ticket) throws TicketValidationException {
        if(ticket.getTicketId() != null) {
            throw new TicketValidationException("Id must be null of a new ticket.");
        }

        if(ticket.getTicketEvents() != null) {
            throw new TicketValidationException("Event must be null of a new ticket.");
        }
    }
}
