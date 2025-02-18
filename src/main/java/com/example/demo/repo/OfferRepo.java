package com.example.demo.repo;

import com.example.demo.dbo.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfferRepo extends JpaRepository<Offer, Long> {
}
