package com.example.issue_ticket_tracker.validator;

import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.validator.exception.TicketValidationException;
import org.springframework.stereotype.Component;

@Component
public class PatchTicketValidator implements TicketValidator {

    @Override
    public void validate(Ticket ticket) throws TicketValidationException {
        if(ticket.getTicketId() == null) {
            throw new TicketValidationException("Id must not be null.");
        }

        if(ticket.getTicketEvents() != null) {
            throw new TicketValidationException("Event must be null.");
        }

        if(ticket.getStatus() != null) {
            if(ticket.getStatus().size() != 1) {
                throw new TicketValidationException("Only 1 status is accepted.");
            }

            if(ticket.getStatus().iterator().next().getTicketStatusId() != null) {
                throw new TicketValidationException("Status cannot be updated. It must be an insertion.");
            }
        }
    }
}
