package com.kenso.web.service;

import com.kenso.web.dto.AirlineDto;

import java.util.List;

public interface AirlineService {
    List<AirlineDto> findAllAirlines();
}
