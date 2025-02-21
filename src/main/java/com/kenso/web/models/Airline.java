package com.kenso.web.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "airline", schema = "flight_tracking_application")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "airline_name")
    private String airlineName;

    @Column(name = "airline_code")
    private String airlineCode;

    @Column(name = "website_url")
    private String websiteURL;

    @Column(name = "logo_url")
    private String logoURL;

    @OneToMany(mappedBy = "airline")
    private List<Flight> flights;
}
