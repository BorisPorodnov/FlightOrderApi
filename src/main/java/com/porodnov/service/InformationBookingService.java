package com.porodnov.service;

import com.porodnov.dao.InformationBookingDao;
import com.porodnov.dto.InformationBooking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationBookingService {

    private final InformationBookingDao informationBookingDao;

    public List <InformationBooking> getInformationOnBooking(InformationBooking informationBooking) {
       return informationBookingDao.getInfoOnBooking(informationBooking);
    }

}
