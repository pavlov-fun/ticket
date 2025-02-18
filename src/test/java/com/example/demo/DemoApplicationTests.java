package com.example.demo;

import com.example.demo.dbo.Flight;
import com.example.demo.dbo.Offer;
import com.example.demo.dbo.Ticket;
import com.example.demo.repo.FligtRepo;
import com.example.demo.service.TicketSevice;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private FligtRepo fligtRepo;

    @Autowired
    private TicketSevice ticketSevice;

    @Test
    void contextLoads() {
        System.out.println("Start contextLoads");

        Flight flight = new Flight();
        flight.setDate(new Date());
        flight.setDestination("SKG");

        Offer offer1 = new Offer("1", "1", new BigDecimal(1000));
        Offer offer2 = new Offer("2", "2", new BigDecimal(2000));
        flight.getOffers().add(offer1);
        flight.getOffers().add(offer2);

        Flight savedFlight = fligtRepo.save(flight);
        Set<Long> offersIds = savedFlight.getOffers().stream().map(Offer::getId).collect(Collectors.toSet());

        Ticket savedTicket = ticketSevice.buy(savedFlight.getId(), offersIds);
        savedTicket.getTicketOffers().forEach(ticketOffer -> System.out.println("TicketOffer id " + ticketOffer.getId()));

        System.out.println("Finish contextLoads");
    }

}
