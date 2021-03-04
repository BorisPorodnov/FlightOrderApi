package com.porodnov.service;

import com.porodnov.dao.FlightDao;
import com.porodnov.dto.FlightFilter;
import com.porodnov.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightService {

    private final FlightDao daoFlight;

    public List<Flight> getFlight(FlightFilter flightFilter) {
        return daoFlight.getFlightInformation(flightFilter);
    }

}
