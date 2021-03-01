package com.porodnov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.OffsetDateTime;

@Getter
@Setter
@Accessors(chain = true)
public class Flight {
    private String id;
    private String number;
    private String departureCity;
    private String arrivalCity;
    private String departureAirport;
    private String arrivalAirport;
    private OffsetDateTime scheduledDeparture;
    private OffsetDateTime scheduledArrival;
}
