package com.porodnov.dto;

import com.porodnov.utils.DatePeriod;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FlightFilter {
    private String departure;
    private String destination;
    private DatePeriod period;
}
