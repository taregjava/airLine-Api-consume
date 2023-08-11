package com.halfacode.travelagency.dto;

import lombok.Data;

@Data
public class FlightScheduleDTO {

    private String airline_iata;
    private String airline_icao;
    private String flight_iata;
    private String flight_icao;
    private String flight_number;
    private String dep_iata;
    private String dep_icao;
    private String dep_terminal;
    private String dep_gate;
    private String dep_time;
    private String dep_time_utc;
    private String arr_iata;
    private String arr_icao;
    private String arr_terminal;
    private String arr_gate;
    private String arr_baggage;
    private String cs_airline_iata;
    private String cs_flight_number;
    private String cs_flight_iata;
    private String status;
    private Integer duration;
    private String delayed;
    private String dep_delayed;
    private String arr_delayed;
    private String aircraft_icao;
    private Integer arr_time_ts;
    private Integer dep_time_ts;
}
