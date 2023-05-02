package com.example.issue_ticket_tracker.repository.entity;


import com.example.issue_ticket_tracker.service.model.Priority;
import jakarta.persistence.*;

import java.util.*;

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

    // TODO: Nem teszem bele equals, hashCode, toString-be...
    @OneToOne(mappedBy = "ticket", cascade = CascadeType.ALL)
    private TicketDetailEntity detail;

    // TODO: Nem teszem bele equals, hashCode, toString-be...
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ticket_to_status",
            joinColumns = @JoinColumn(name = "ticket_id"),
            inverseJoinColumns = @JoinColumn(name = "status_id"))
    private Set<TicketStatusEntity> status;

    // TODO: Nem teszem bele equals, hashCode, toString-be...
    @OneToMany(mappedBy = "ticket", fetch=FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Set<TicketStatusEntity> getStatus() {
        return status;
    }

    public void setStatus(Set<TicketStatusEntity> status) {
        if(this.status != null) {
            this.status.clear();
        }
        status.forEach(s-> add(s));
    }

    public void add(TicketStatusEntity ticketStatusEntity) {
        if(this.status == null) {
            this.status = new LinkedHashSet<>();
        }
        this.status.add(ticketStatusEntity);
    }

    public List<TicketEventEntity> getTicketEvents() {
        return ticketEvents;
    }

    public void setTicketEvents(List<TicketEventEntity> ticketEvents) {
        this.ticketEvents = ticketEvents;
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
