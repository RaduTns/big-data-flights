package com.kenso.web.repository;

import com.kenso.web.models.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findByAirportCode(String airportCode);
}
