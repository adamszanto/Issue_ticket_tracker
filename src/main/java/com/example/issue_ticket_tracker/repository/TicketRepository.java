package com.example.issue_ticket_tracker.repository;

import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <TicketEntity, Integer> {
}
