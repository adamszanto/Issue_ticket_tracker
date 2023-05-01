package com.example.issue_ticket_tracker.repository.entity;


import com.example.issue_ticket_tracker.service.model.Priority;
import com.example.issue_ticket_tracker.service.model.ticket.TicketDetail;
import com.example.issue_ticket_tracker.service.model.ticket.TicketEvent;
import com.example.issue_ticket_tracker.service.model.ticket.TicketStatus;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

// spring-boot-starter-data-jpa

@Entity
@Table(name = "ticket")
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ticketId;

    @Column(name = "title")
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority")
    private Priority priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id")
    private TicketDetailEntity detail;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status")
    private TicketStatusEntity status;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private List<TicketEventEntity> ticketEvents;





    public TicketEntity(Integer ticketId, String title, Priority priority) {
        this.ticketId = ticketId;
        this.title = title;
        this.priority = priority;
    }

    public TicketEntity() {
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String body) {
        this.title = body;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public TicketDetailEntity getDetail() {
        return detail;
    }

    public void setDetail(TicketDetailEntity detail) {
        this.detail = detail;
    }

    public TicketStatusEntity getTicketStatusEntity() {
        return status;
    }

    public void setTicketStatusEntity(TicketStatusEntity status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TicketEntity that = (TicketEntity) o;

        if (!Objects.equals(ticketId, that.ticketId)) return false;
        return Objects.equals(title, that.title);
    }

    @Override
    public int hashCode() {
        int result = ticketId != null ? ticketId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
}
