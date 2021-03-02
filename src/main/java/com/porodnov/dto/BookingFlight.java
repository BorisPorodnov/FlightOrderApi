package com.porodnov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingFlight {
    private String name;
    private String passport;
    private String contacts;
    @JsonProperty("flight_id")
    private int flightId;
    @JsonProperty("fare_conditions")
    private String fareCondition;
    private Integer amount;
}
