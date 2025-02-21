package com.kenso.web.dto;

import com.kenso.web.models.Airline;
import com.kenso.web.models.Airport;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightDto {

    private Long id;
    private String flightNumber;
    private String callsign;
    private String flightICAO;
    private Airline airline;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String scheduledDepartureTime;
    private String scheduledArrivalTime;
    private String actualDepartureTime;
    private String actualArrivalTime;
    private Double currentLongitude;
    private Double currentLatitude;
    private Double currentAltitude;
    private String aircraftType;
    private Double groundSpeed;
    private Integer delay;
    private Integer actualDelay;
    private String onGround;

}
