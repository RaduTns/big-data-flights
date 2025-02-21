package com.kenso.web.service;

import com.kenso.web.dto.FlightDto;
import com.kenso.web.models.Flight;

import java.util.List;

public interface FlightService {
    List<FlightDto> getAllFlights();
    FlightDto getFlightByCallsign(String callsign);
    FlightDto getFlightByFlightNumber(String flightNumber);
    List<FlightDto> getFlightsByDepartureAirport(String departureAirportCode);
    List<FlightDto> getFlightsByArrivalAirport(String arrivalAirportCode);
    List<FlightDto> getFlightsByDelay(Float delay);
    List<FlightDto> getFlightsByActualDelay(Float actualDelay);
    void saveFlights(List<Flight> flights);

    void saveFlight(Flight flight);

}
