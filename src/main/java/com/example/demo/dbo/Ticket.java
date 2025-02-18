package com.example.demo.dbo;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Ticket {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private Date date;

    @ManyToOne
    private Flight flight;

    @OneToMany
    @Cascade(CascadeType.ALL)
    private Set<TicketOffer> ticketOffers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Set<TicketOffer> getTicketOffers() {
        return ticketOffers;
    }

    public void setTicketOffers(Set<TicketOffer> ticketOffers) {
        this.ticketOffers = ticketOffers;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
