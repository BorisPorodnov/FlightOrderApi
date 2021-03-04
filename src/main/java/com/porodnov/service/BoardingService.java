package com.porodnov.service;

import com.porodnov.dto.BookingResponse;
import com.porodnov.dto.RegistrationOnFlight;
import com.porodnov.dao.BoardingDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardingService {

    private final BoardingDao boardingDao;

    public void getBoardingRegistration(RegistrationOnFlight registrationOnFlight) {
        boardingDao.getBoardingPass(registrationOnFlight);
    }

}
