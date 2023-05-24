package com.example.issue_ticket_tracker.validator.exception;

public class TicketValidationException extends Exception {
    public TicketValidationException() {
    }

    public TicketValidationException(String message) {
        super(message);
    }

    public TicketValidationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TicketValidationException(Throwable cause) {
        super(cause);
    }

    public TicketValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

}
