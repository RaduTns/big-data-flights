package com.kenso.web.controller;

import com.kenso.web.dto.AirlineDto;
import com.kenso.web.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

import java.util.List;

@Controller
public class AirlineController {
    private AirlineService airlineService;

    @Autowired
    public AirlineController(AirlineService airlineService) {
        this.airlineService = airlineService;
    }

    @GetMapping("/airlines")
    public List<AirlineDto> listAirlines() {
        List<AirlineDto> airlines = airlineService.findAllAirlines();
        return airlines;

    }
}
