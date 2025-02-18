package com.example.demo.dbo;

import jakarta.persistence.*;

@Entity
public class TicketOffer {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Offer offer;

    @ManyToOne
    private Prise prise;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Prise getPrise() {
        return prise;
    }

    public void setPrise(Prise prise) {
        this.prise = prise;
    }
}
