package com.porodnov.controller;

import com.porodnov.dto.InformationBooking;
import com.porodnov.service.InformationBookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InformationBookingController {

    private final InformationBookingService informationBookingService;

    @GetMapping("/bookingRef")
    public List<InformationBooking> getInfoOnFlight(InformationBooking informationBooking) {
        return informationBookingService.getInformationOnBooking(informationBooking);
    }

}
