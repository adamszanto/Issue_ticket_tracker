package com.example.issue_ticket_tracker.service;

import com.example.issue_ticket_tracker.mapper.TicketMapper;
import com.example.issue_ticket_tracker.repository.TicketRepository;
import com.example.issue_ticket_tracker.repository.entity.TicketDetailEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import com.example.issue_ticket_tracker.repository.entity.TicketStatusEntity;
import com.example.issue_ticket_tracker.service.model.ticket.Ticket;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;
import com.example.issue_ticket_tracker.service.model.ticket.TicketStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TicketServiceImplTest {

    @Mock
    private TicketRepository ticketRepository;
    @Mock
    private TicketDetail ticketDetail;
    @Mock
    private TicketStatus ticketStatus;
    @Mock
    private TicketMapper ticketMapper;
    private TicketServiceImpl underTest;

//    @BeforeEach
//    void init() {
//        ticketMapper = new TicketMapper();
//        underTest = new TicketServiceImpl(ticketRepository, ticketMapper);
//    }

    @Test
    void shouldUnderTestCreateNewTicketWhenTicketProvided() {
        // Given
        Ticket ticket = new Ticket();
        TicketDetail ticketDetail = new TicketDetail();
        TicketStatus ticketStatus = new TicketStatus();

        ticketDetail.setTicketBody("Minden rendben van");
        ticketStatus.setTicketStatusId(10);
        ticketStatus.setStatus("Nem változott a státusz");

        ticket.setTicketId(101);
        ticket.setTitle("Minden");
        ticket.setDetail(new TicketDetail());
        ticket.setStatus(new TicketStatus());

        Ticket expectedResult = new Ticket();
        expectedResult.setTicketId(ticket.getTicketId());
        expectedResult.setTitle(ticket.getTitle());
        expectedResult.setDetail(ticket.getDetail());

        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setTicketId(ticket.getTicketId());
        ticketEntity.setTitle(ticket.getTitle());
        ticketEntity.setDetail(ticketMapper.convertDetailModeltoEntity(ticket.getDetail()));


        when(ticketRepository.save(ticketEntity)).thenReturn(ticketEntity);
        when(ticketMapper.convertDetailModeltoEntity(ticketDetail)).thenReturn(new TicketDetailEntity());
        when(ticketMapper.convertTicketStatusModelToEntity(ticketStatus)).thenReturn(new TicketStatusEntity());
        when(ticketMapper.convertTicketEntitytoModel(ticketEntity)).thenReturn(expectedResult);

        // When
        Ticket result = underTest.createTicket(ticket);

        // Then
        assertEquals(result, expectedResult);
        verify(ticketRepository).save(ticketEntity);

    }

}
