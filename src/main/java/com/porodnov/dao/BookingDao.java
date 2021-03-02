package com.porodnov.dao;

import com.porodnov.dto.BookingFlight;
import com.porodnov.dto.BookingResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookingDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<BookingResponse> getBookingTicket(List<BookingFlight> bookingFlight) {

        Integer seqBookRef = jdbcTemplate.queryForObject("SELECT nextval('book_ref_seq')", EmptySqlParameterSource.INSTANCE, Integer.class);
        String seqTicketNo = jdbcTemplate.queryForObject("SELECT nextval('ticket_no_seq')", EmptySqlParameterSource.INSTANCE, String.class);

        LocalDateTime localDateTime = LocalDateTime.now();

        String sql =
                " INSERT INTO bookings " +
                " (book_ref, book_date, total_amount) " +
                " VALUES" +
                " (:seqBookRef, :localDateTime, 0);";

        MapSqlParameterSource mapParam = new MapSqlParameterSource();
        mapParam.addValue("seqBookRef", seqBookRef);
        mapParam.addValue("localDateTime", localDateTime);
        jdbcTemplate.update(sql, mapParam);

        sql =
                " INSERT INTO tickets (ticket_no, book_ref, passenger_id, passenger_name) " +
                " VALUES(:seqTicketNo, :seqBookRef, :pass, :name); ";

        MapSqlParameterSource mapParam1 = new MapSqlParameterSource();
        mapParam1.addValue("seqTicketNo", seqTicketNo);
        mapParam1.addValue("seqBookRef", seqBookRef);
        mapParam1.addValue("pass", bookingFlight.get(0).getPassport());
        mapParam1.addValue("name", bookingFlight.get(0).getName());
        jdbcTemplate.update(sql, mapParam1);

        sql =
                "INSERT INTO ticket_flights (ticket_no, flight_id, fare_conditions, amount) " +
                "VALUES      (:seqTicketNo, :flightId, :fareCondition, 0) ";

        MapSqlParameterSource mapSql = new MapSqlParameterSource();
        mapSql.addValue("seqTicketNo", seqTicketNo);
        mapSql.addValue("flightId", bookingFlight.get(0).getFlightId());
        mapSql.addValue("fareCondition", bookingFlight.get(0).getFareCondition());
        jdbcTemplate.update(sql, mapSql);

        List list = new ArrayList<>();

        list.add(new BookingResponse(seqBookRef, seqTicketNo));

        return list;
    }
}
