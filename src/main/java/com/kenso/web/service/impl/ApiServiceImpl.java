package com.kenso.web.service.impl;

import com.kenso.web.models.Flight;
import com.kenso.web.service.ApiService;
import com.kenso.web.service.FlightService;
import org.opensky.api.OpenSkyApi;
import org.opensky.model.OpenSkyStates;
import org.opensky.model.StateVector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApiServiceImpl implements ApiService {

    private final OpenSkyApi openSkyApi;
    private final FlightService flightService;

    @Autowired
    public ApiServiceImpl(FlightService flightService,
                          @Value("${api.opensky.username}") String username,
                          @Value("${api.opensky.password}") String password) {
        this.openSkyApi = new OpenSkyApi(username, password);
        this.flightService = flightService;
    }

    @Override
    public OpenSkyStates fetchFlights() {
        OpenSkyStates openSkyStates;
        try {
            openSkyStates = openSkyApi.getStates(0, null);
            if (openSkyStates != null) {
                List<Flight> flights = openSkyStates.getStates().stream().map(this::mapStateToFlight).collect(Collectors.toList());
                flightService.saveFlights(flights);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return openSkyStates;
    }

    private Flight mapStateToFlight(StateVector state) {
        Flight flight = new Flight();
        flight.setCurrentAltitude(state.getGeoAltitude());
        flight.setCurrentLongitude(state.getLongitude());
        flight.setCurrentLatitude(state.getLatitude());
        flight.setGroundSpeed(state.getVelocity());
        flight.setFlightICAO(state.getIcao24());
        flight.setCallsign(state.getCallsign().trim());

        return flight;
    }
}
