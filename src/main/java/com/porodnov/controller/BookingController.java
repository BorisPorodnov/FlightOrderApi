package com.porodnov.controller;

import com.porodnov.dto.BookingFlight;
import com.porodnov.dto.BookingResponse;
import com.porodnov.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/bookings")
    public List<BookingResponse> bookingsFlights
        (@RequestBody List<BookingFlight> bookingFlight){
        return bookingService.getBooking(bookingFlight);
    }
}
