package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.mapper.TicketDetailsMapper;
import com.example.issue_ticket_tracker.mapper.TicketEventMapper;
import com.example.issue_ticket_tracker.mapper.TicketMapper;
import com.example.issue_ticket_tracker.mapper.TicketStatusMapper;
import com.example.issue_ticket_tracker.repository.TicketRepository;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;
    private TicketMapper ticketMapper;
    private TicketServiceImpl underTest;
    private TicketDetailsMapper ticketDetailsMapper;
    private TicketStatusMapper ticketStatusMapper;
    private TicketEventMapper ticketEventMapper;

    @BeforeEach
    void init() {
        ticketDetailsMapper = new TicketDetailsMapper();
        ticketStatusMapper = new TicketStatusMapper();
        ticketEventMapper = new TicketEventMapper();

        ticketMapper = new TicketMapper(ticketDetailsMapper, ticketStatusMapper, ticketEventMapper);
        underTest = new TicketServiceImpl(ticketRepository, ticketMapper);
    }

    @Test
    void shouldUnderTestCreateNewTicket() {
        // Given
        Ticket ticket = new Ticket();
        ticket.setTicketId(101);
        ticket.setTitle("Test");

        Ticket expectedResult = new Ticket();
        expectedResult.setTicketId(ticket.getTicketId());
        expectedResult.setTitle(ticket.getTitle());

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketId(ticket.getTicketId());
        ticketEntity.setTitle(ticket.getTitle());

        when(ticketRepository.save(ticketEntity)).thenReturn(ticketEntity);
        // When
        Ticket result = underTest.createTicket(ticket);

        // Then
        assertEquals(result, expectedResult);
        verify(ticketRepository).save(ticketEntity);
    }

    @Test
    void shouldUnderTestGetTicketGivenId() {
        Ticket ticket = new Ticket();
        ticket.setTicketId(101);
        ticket.setTitle("Test");


        Ticket expectedResult = new Ticket();
        expectedResult.setTicketId(ticket.getTicketId());
        expectedResult.setTitle(ticket.getTitle());

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketId(ticket.getTicketId());
        ticketEntity.setTitle(ticket.getTitle());

        Optional<TicketEntity> optionalTicketEntity = Optional.of(ticketEntity);

        when(ticketRepository.findById(101)).thenReturn(optionalTicketEntity);



        // When
        Ticket result = underTest.getTicketById(101);

        // Then

        assertEquals(result, expectedResult);
        verify(ticketRepository).findById(101);
    }
}
