package com.porodnov.controller;

import com.porodnov.dto.BookingResponse;
import com.porodnov.dto.RegistrationOnFlight;
import com.porodnov.service.BoardingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class RegistrationsBoardingController {

    private final BoardingService boardingService;

    @PostMapping ("/boarding-pass")
    public void getRegistrationBoarding(@RequestBody RegistrationOnFlight registrationOnFlight){

         boardingService.getBoardingRegistration(registrationOnFlight);
    }
}
