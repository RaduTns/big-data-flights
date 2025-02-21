package com.kenso.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "flight", schema = "flight_tracking_application")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="flight_number")
    private String flightNumber;

    private String callsign;

    @Column(name = "flight_icao")
    private String flightICAO;

    @ManyToOne
    @JoinColumn(name = "airline", referencedColumnName = "id")
    private Airline airline;

    @ManyToOne
    @JoinColumn(name = "departure_airport", referencedColumnName = "id")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "arrival_airport", referencedColumnName = "id")
    private Airport arrivalAirport;

    @Column(name="scheduled_departure_time")
    private String scheduledDepartureTime;

    @Column(name="scheduled_arrival_time")
    private String scheduledArrivalTime;

    @Column(name="actual_departure_time")
    private String actualDepartureTime;

    @Column(name="actual_arrival_time")
    private String actualArrivalTime;

    @Column(name="current_longitude")
    private Double currentLongitude;

    @Column(name="current_latitude")
    private Double currentLatitude;

    @Column(name="current_altitude")
    private Double currentAltitude;

    @Column(name="aircraft_type")
    private String aircraftType;

    @Column(name="ground_speed")
    private Double groundSpeed;

    private Integer delay;

    @Column(name="actual_delay")
    private Integer actualDelay;

    @Column(name = "status")
    private String onGround;
}
