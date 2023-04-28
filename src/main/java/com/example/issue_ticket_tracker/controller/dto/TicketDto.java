package com.example.issue_ticket_tracker.controller.dto;

import jakarta.validation.constraints.NotNull;

public class TicketDto {
    @NotNull
    private String title;
}
