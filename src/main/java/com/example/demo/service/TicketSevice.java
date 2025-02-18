package com.example.demo.service;


import com.example.demo.dbo.Flight;
import com.example.demo.dbo.Offer;
import com.example.demo.dbo.Ticket;
import com.example.demo.dbo.TicketOffer;
import com.example.demo.repo.FligtRepo;
import com.example.demo.repo.OfferRepo;
import com.example.demo.repo.TicketRepo;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TicketSevice {

    private final TicketRepo ticketRepo;

    private final FligtRepo fligtRepo;

    private final OfferRepo offerRepo;

    public TicketSevice(TicketRepo ticketRepo, FligtRepo fligtRepo, OfferRepo offerRepo) {
        this.ticketRepo = ticketRepo;
        this.fligtRepo = fligtRepo;
        this.offerRepo = offerRepo;
    }

    @Transactional
    public Ticket buy(Long flightId, Set<Long> offersId) {
        Optional<Flight> flight = fligtRepo.findById(flightId);
        List<Offer> offers = offerRepo.findAllById(offersId);
        Ticket ticket = new Ticket();
        flight.ifPresent(f -> {
            ticket.setFlight(f);

            offers.forEach(offer -> {
                TicketOffer ticketOffer = new TicketOffer();
                ticketOffer.setOffer(offer);
                ticketOffer.setPrise(offer.getPrise());
                ticket.getTicketOffers().add(ticketOffer);
            });

            ticketRepo.save(ticket);
        });
        return ticket;
    }

}
