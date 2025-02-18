package com.example.demo.service;

import com.example.demo.dbo.Offer;
import com.example.demo.dbo.Prise;
import com.example.demo.repo.OfferRepo;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class OfferService {

    private final OfferRepo offerRepo;

    public OfferService(OfferRepo offerRepo) {
        this.offerRepo = offerRepo;
    }

    public Offer newOffer(String name, String description, BigDecimal price) {
        Offer offer = new Offer(name, description, price);
        return offerRepo.save(offer);
    }

    public void updateOffer(Long id, String name, String description, BigDecimal price) {
        Optional<Offer> byId = offerRepo.findById(id);
        byId.ifPresent(offer -> {
            Prise prise = new Prise(name, description, price);
            offer.setPrise(prise);
            offerRepo.save(offer);
        });
    }
}
