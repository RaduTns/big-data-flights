package com.kenso.web.repository;

import com.kenso.web.models.Airport;
import com.kenso.web.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {

    Flight findByCallsign(String callsign);
    Flight findByFlightNumber(String flightNumber);
    List<Flight> findByDepartureAirport(Airport departureAirport);
    List<Flight> findByArrivalAirport(Airport arrivalAirport);
    List<Flight> findByDelay(Float delay);
    List<Flight> findByActualDelay(Float actualDelay);
}
