package com.example.demo.dbo;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Offer {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne(cascade = {CascadeType.ALL})
    private Prise prise;

    public Offer(String name, String description, BigDecimal price) {
        this.prise = new Prise(name, description, price);
    }

    public Offer() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Prise getPrise() {
        return prise;
    }

    public void setPrise(Prise prise) {
        this.prise = prise;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Objects.equals(id, offer.id) && Objects.equals(prise, offer.prise);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prise);
    }
}
