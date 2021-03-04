package com.porodnov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationOnFlight {
    @JsonProperty("flight_id")
    private int flightId;
    @JsonProperty("seat_no")
    private String seatNo;
}
