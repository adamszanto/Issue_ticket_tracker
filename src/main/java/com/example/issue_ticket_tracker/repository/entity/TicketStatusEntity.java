package com.example.issue_ticket_tracker.repository.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ticket_status")
public class TicketStatusEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer statusId;
    @Column(name = "status")
    private String status;

    // TODO: Nem teszem bele equals, hashCode, toString-be...
    @ManyToMany
    private Set<TicketEntity> ticket;

    public Integer getTicketStatusId() {
        return statusId;
    }

    public void setTicketStatusId(Integer ticketStatusId) {
        this.statusId = ticketStatusId;
    }

    public String getStatus() {
        return status;
    }

    public void add(TicketEntity ticketEntity) {
        if(this.ticket == null) {
            ticket = new HashSet<>();
        }
        ticket.add(ticketEntity);
    }

    public Set<TicketEntity> getTicket() {
        return ticket;
    }

    public void setTicket(Set<TicketEntity> tickets) {
        if(this.ticket != null) {
            ticket.clear();
        }

        tickets.forEach(s -> add(s));
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
