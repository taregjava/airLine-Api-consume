package com.halfacode.travelagency.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FlightDTO {
    // Define fields matching the API response
    private String hex;
    private String reg_number;
    private String flag;
    private double lat;
    private double lng;
    private double alt;
    private int dir;
    private int speed;
    private double v_speed;
    private String squawk;
    private String flight_number;
    private String flight_icao;
    private String flight_iata;
    private String dep_icao;
    private String dep_iata;
    private String arr_icao;
    private String arr_iata;
    private String airline_icao;
    private String airline_iata;
    private String aircraft_icao;
    private long updated;
    private String status;
}
