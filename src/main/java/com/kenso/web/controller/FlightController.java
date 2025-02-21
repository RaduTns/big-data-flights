package com.kenso.web.controller;

import com.kenso.web.dto.FlightDto;
import com.kenso.web.models.Flight;
import com.kenso.web.service.FlightService;
import com.kenso.web.service.impl.FlightServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService flightService;

    public FlightController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping
    public ResponseEntity<List<FlightDto>> getAll() {
        List<FlightDto> flights = flightService.getAllFlights();
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flights);
        }
    }

    @GetMapping("/callsign/{callsign}")
    public ResponseEntity<FlightDto> getByCallsign(@PathVariable String callsign) {
        FlightDto flight = flightService.getFlightByCallsign(callsign);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(flight);
        }
    }

    @GetMapping("/flight-number/{flightNumber}")
    public ResponseEntity<FlightDto> getByFlightNumber(@PathVariable String flightNumber) {
        FlightDto flight = flightService.getFlightByFlightNumber(flightNumber);
        if (flight == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(flight);
        }
    }

    @GetMapping("/departure-airport/{departureAirportCode}")
    public ResponseEntity<List<FlightDto>> getByDepartureAirport(@PathVariable String departureAirportCode) {
        List<FlightDto> flights = flightService.getFlightsByDepartureAirport(departureAirportCode);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flights);
        }
    }

    @GetMapping("/arrival-airport/{arrivalAirportCode}")
    public ResponseEntity<List<FlightDto>> getByArrivalAirport(@PathVariable String arrivalAirportCode) {
        List<FlightDto> flights = flightService.getFlightsByArrivalAirport(arrivalAirportCode);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flights);
        }
    }

    @GetMapping("/delay/{delay}")
    public ResponseEntity<List<FlightDto>> getByDelay(@PathVariable Float delay) {
        List<FlightDto> flights = flightService.getFlightsByDelay(delay);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flights);
        }
    }

    @GetMapping("/actual-delay/{actualDelay}")
    public ResponseEntity<List<FlightDto>> getByActualDelay(@PathVariable Float actualDelay) {
        List<FlightDto> flights = flightService.getFlightsByActualDelay(actualDelay);
        if (flights.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(flights);
        }
    }

    @PostMapping
    public ResponseEntity<Flight> saveFlight(@RequestBody Flight flight) {
        flightService.saveFlight(flight);
        return ResponseEntity.status(HttpStatus.CREATED).body(flight);
    }
}