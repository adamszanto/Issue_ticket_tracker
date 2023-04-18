package com.example.issue_ticket_tracker.repository;

import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketingRepository extends JpaRepository <TicketEntity, Integer> {

}
