package com.kenso.web.controller;

import com.kenso.web.service.ApiService;
import org.opensky.model.OpenSkyStates;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/api")
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }
    @GetMapping
    public ResponseEntity<OpenSkyStates> getAllStates (){
        return ResponseEntity.ok(apiService.fetchFlights());
    }
}
