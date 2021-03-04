package com.porodnov.dao;

import com.porodnov.dto.InformationBooking;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class InformationBookingDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public List<InformationBooking> getInfoOnBooking(InformationBooking informationBooking) {

        String sqlInfo =
                " SELECT   b.book_ref, " +
                "         t.ticket_no, " +
                "         t.passenger_id, " +
                "         t.passenger_name, " +
                "         tf.fare_conditions, " +
                "         tf.amount, " +
                "         f.scheduled_departure_local, " +
                "         f.scheduled_arrival_local, " +
                "         f.departure_city || ' (' || f.departure_airport || ')' AS departure, " +
                "         f.arrival_city || ' (' || f.arrival_airport || ')' AS arrival, " +
                "         f.status, " +
                "         bp.seat_no " +
                " FROM     bookings b " +
                "         JOIN tickets t ON b.book_ref = t.book_ref " +
                "         JOIN ticket_flights tf ON tf.ticket_no = t.ticket_no " +
                "         JOIN flights_v f ON tf.flight_id = f.flight_id " +
                "         LEFT JOIN boarding_passes bp ON tf.flight_id = bp.flight_id " +
                "                                     AND tf.ticket_no = bp.ticket_no " +
                " WHERE    b.book_ref = '400' " +
                " ORDER BY t.ticket_no, f.scheduled_departure ";

        RowMapper<InformationBooking> responseMapper = (rs, rowNum) -> new InformationBooking()
            .setBookRef(rs.getString("book_ref"))
            .setTicketNo(rs.getString("ticket_no"))
            .setPassengerId(rs.getString("passenger_id"))
            .setPassengerName(rs.getString("passenger_name"))
            .setFareCondition(rs.getString("fare_conditions"))
            .setAmount(rs.getInt("amount"))
            .setDeparture(rs.getString("departure"))
            .setArrival(rs.getString("arrival"))
            .setStatus(rs.getString("status"));

       return  jdbcTemplate.query(sqlInfo, responseMapper);

    }

}
