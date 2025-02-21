package com.kenso.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AirportDto {

    private Long id;
    private String airportCode;
    private String airportName;
    private String airportCity;
    private String airportCountry;
    private Float airportLongitude;
    private Float airportLatitude;
}
