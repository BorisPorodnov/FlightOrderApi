package com.porodnov.controller;

import com.porodnov.dto.FlightFilter;
import com.porodnov.model.Flight;
import com.porodnov.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/search")
    public List<Flight> searchFlight(@RequestBody FlightFilter flightFilter) {
        return flightService.getFlight(flightFilter);
    }

}