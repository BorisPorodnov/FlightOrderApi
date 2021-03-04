package com.porodnov.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
public class InformationBooking {
    @JsonProperty("book_ref")
    private String bookRef;
    @JsonProperty("ticket_no")
    private String ticketNo;
    @JsonProperty("passenger_id")
    private String passengerId;
    @JsonProperty("passenger_name")
    private String passengerName;
    @JsonProperty("fare_condition")
    private String fareCondition;
    private int amount;
    private String departure;
    private String arrival;
    private String status;
}
