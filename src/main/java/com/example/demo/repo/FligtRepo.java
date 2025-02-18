package com.example.demo.repo;

import com.example.demo.dbo.Flight;
import com.example.demo.dbo.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FligtRepo extends JpaRepository<Flight, Long> {
}
