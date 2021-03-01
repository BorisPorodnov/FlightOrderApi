package com.porodnov.dao;

import com.porodnov.dto.FlightFilter;
import com.porodnov.model.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class DaoFlight {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<Flight> getFlightInformation(FlightFilter flightFilter) {
        String sql =
            " SELECT * " +
            " FROM flights_v f " +
            " WHERE f.departure_city = :departure " +
            " AND f.arrival_city = :destination " +
            " AND f.scheduled_departure_local > :start " +
            " AND f.scheduled_departure_local < :end ";

        MapSqlParameterSource parameters = new MapSqlParameterSource();
        parameters.addValue("departure", flightFilter.getDeparture());
        parameters.addValue("destination", flightFilter.getDestination());
        parameters.addValue("start", flightFilter.getPeriod().getStart());
        parameters.addValue("end", flightFilter.getPeriod().getEnd());

        RowMapper<Flight> responseMapper = (rs, rowNum) -> new Flight()
            .setId(rs.getString("flight_id"))
            .setNumber(rs.getString("flight_no"))
            .setArrivalCity(rs.getString("arrival_city"))
            .setDepartureCity(rs.getString("departure_city"))
            .setDepartureAirport(rs.getString("departure_airport"))
            .setArrivalAirport(rs.getString("arrival_airport"))
            .setScheduledDeparture(rs.getObject("scheduled_departure", OffsetDateTime.class))
            .setScheduledArrival(rs.getObject("scheduled_arrival",OffsetDateTime.class));

        return jdbcTemplate.query(sql, parameters, responseMapper);
    }

}
