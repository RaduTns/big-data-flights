package com.kenso.web.service.impl;

import com.kenso.web.dto.AirlineDto;
import com.kenso.web.models.Airline;
import com.kenso.web.repository.AirlineRepository;
import com.kenso.web.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AirlineServiceImpl implements AirlineService {

    private AirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public List<AirlineDto> findAllAirlines() {
        List<Airline> airlines = airlineRepository.findAll();
        return airlines.stream().map((airline) -> mapToAirlineDto(airline)).collect(Collectors.toList());
    }

    public AirlineDto mapToAirlineDto(Airline airline){
        AirlineDto airlineDto = AirlineDto.builder()
                .id(airline.getId())
                .airlineName(airline.getAirlineName())
                .airlineCode(airline.getAirlineCode())
                .websiteURL(airline.getWebsiteURL())
                .logoURL(airline.getLogoURL())
                .build();
        return airlineDto;
    }
}
