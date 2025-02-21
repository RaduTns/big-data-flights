package com.kenso.web.service;

import com.kenso.web.dto.AirportDto;

import java.util.List;

public interface AirportService {

    List<AirportDto> findAllAirports();
}
