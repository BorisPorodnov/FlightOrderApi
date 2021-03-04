package com.porodnov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingResponse {
    private int bookRef;
    @JsonProperty("ticket_no")
    private String ticketNo;
}
