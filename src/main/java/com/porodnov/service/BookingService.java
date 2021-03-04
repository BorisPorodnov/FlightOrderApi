package com.porodnov.service;

import com.porodnov.dao.BookingDao;
import com.porodnov.dto.BookingFlight;
import com.porodnov.dto.BookingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingDao bookingDao;

    public List<BookingResponse> getBooking(List<BookingFlight> bookingFlight) {
        return bookingDao.getBookingTicket(bookingFlight);
    }

}
