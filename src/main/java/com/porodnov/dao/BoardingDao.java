package com.porodnov.dao;

import com.porodnov.dto.RegistrationOnFlight;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class BoardingDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public void getBoardingPass(RegistrationOnFlight registrationOnFlight) {
        Integer seqBoardingPasses = jdbcTemplate.queryForObject
            ("SELECT nextval('boarding_pass_seq')", EmptySqlParameterSource.INSTANCE, Integer.class);

        Integer seatSeq = jdbcTemplate.queryForObject
            ("SELECT nextval('seat_no_seq');", EmptySqlParameterSource.INSTANCE, Integer.class);

        String sql =
            " INSERT INTO boarding_passes (ticket_no, flight_id, boarding_no, seat_no) " +
                " VALUES      ( 7900122, :flightId, :seqBoardingPasses, '1DQ') ";

        MapSqlParameterSource map = new MapSqlParameterSource();
        map.addValue("flightId", registrationOnFlight.getFlightId());
        map.addValue("seqBoardingPasses", seqBoardingPasses);
        jdbcTemplate.update(sql, map);
    }

}
