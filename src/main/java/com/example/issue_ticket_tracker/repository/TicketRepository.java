package com.example.issue_ticket_tracker.repository;

import com.example.issue_ticket_tracker.repository.entity.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TicketRepository extends JpaRepository <TicketEntity, Integer> {
    List<TicketEntity> findByName (String name);

}