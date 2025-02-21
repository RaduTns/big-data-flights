package com.kenso.web.service.impl;

import com.kenso.web.dto.FlightDto;
import com.kenso.web.models.Airport;
import com.kenso.web.models.Flight;
import com.kenso.web.repository.AirportRepository;
import com.kenso.web.repository.FlightRepository;
import com.kenso.web.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;
    private final AirportRepository airportRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository, AirportRepository airportRepository) {
        this.flightRepository = flightRepository;
        this.airportRepository = airportRepository;
    }

    public List<FlightDto> getAllFlights() {
        List<Flight> flights = flightRepository.findAll();
        return flights.stream().map(this::mapToFlightDto).collect(Collectors.toList());
    }

    public FlightDto getFlightByCallsign(String callsign) {
        Flight flight = flightRepository.findByCallsign(callsign);
        return mapToFlightDto(flight);
    }

    public FlightDto getFlightByFlightNumber(String flightNumber) {
        Flight flight = flightRepository.findByFlightNumber(flightNumber);
        return mapToFlightDto(flight);
    }

    public List<FlightDto> getFlightsByDepartureAirport(String departureAirportCode) {
        Airport departureAirport = airportRepository.findByAirportCode(departureAirportCode);
        if (departureAirport == null) {
            throw new IllegalArgumentException("Invalid departure airport code: " + departureAirportCode);
        }
        List<Flight> flights = flightRepository.findByDepartureAirport(departureAirport);
        return flights.stream().map(this::mapToFlightDto).collect(Collectors.toList());
    }

    public List<FlightDto> getFlightsByArrivalAirport(String arrivalAirportCode) {
        Airport arrivalAirport = airportRepository.findByAirportCode(arrivalAirportCode);
        if (arrivalAirport == null) {
            throw new IllegalArgumentException("Invalid arrival airport code: " + arrivalAirportCode);
        }
        List<Flight> flights = flightRepository.findByArrivalAirport(arrivalAirport);
        return flights.stream().map(this::mapToFlightDto).collect(Collectors.toList());
    }

    public List<FlightDto> getFlightsByDelay(Float delay) {
        List<Flight> flights = flightRepository.findByDelay(delay);
        return flights.stream().map(this::mapToFlightDto).collect(Collectors.toList());
    }

    public List<FlightDto> getFlightsByActualDelay(Float actualDelay) {
        List<Flight> flights = flightRepository.findByActualDelay(actualDelay);
        return flights.stream().map(this::mapToFlightDto).collect(Collectors.toList());
    }

    @Override
    public void saveFlights(List<Flight> flights) {
        flightRepository.saveAll(flights);
    }

    public void saveFlight (Flight flight){
        flightRepository.save(flight);
    }

    private FlightDto mapToFlightDto(Flight flight) {
        return FlightDto.builder()
                .id(flight.getId())
                .flightNumber(flight.getFlightNumber())
                .callsign(flight.getCallsign())
                .flightICAO(flight.getFlightICAO())
                .airline(flight.getAirline())
                .departureAirport(flight.getDepartureAirport())
                .arrivalAirport(flight.getArrivalAirport())
                .scheduledDepartureTime(flight.getScheduledDepartureTime())
                .scheduledArrivalTime(flight.getScheduledArrivalTime())
                .actualDepartureTime(flight.getActualDepartureTime())
                .actualArrivalTime(flight.getActualArrivalTime())
                .currentLatitude(flight.getCurrentLatitude())
                .currentLongitude(flight.getCurrentLongitude())
                .currentAltitude(flight.getCurrentLatitude())
                .aircraftType(flight.getAircraftType())
                .groundSpeed(flight.getGroundSpeed())
                .delay(flight.getDelay())
                .actualDelay(flight.getActualDelay())
                .onGround(flight.getOnGround())
                .build();
    }
}
