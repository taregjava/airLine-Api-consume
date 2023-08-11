package com.halfacode.travelagency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FlightEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String hex;
    private String registrationNumber;
    private String flag;
    private double latitude;
    private double longitude;
    private int altitude;
    private int direction;
    private int speed;
    private double verticalSpeed;
    private String squawk;
    private String flightNumber;
    private String flightIcaoCode;
    private String flightIataCode;
    private String departureIcaoCode;
    private String departureIataCode;
    private String arrivalIcaoCode;
    private String arrivalIataCode;
    private String airlineIcaoCode;
    private String airlineIataCode;
    private String aircraftIcaoCode;
    private long updated;
    private String status;
}
