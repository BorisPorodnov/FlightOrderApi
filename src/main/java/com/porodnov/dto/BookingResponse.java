package com.porodnov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    private int bookRef;
    private String ticketNo;
}
