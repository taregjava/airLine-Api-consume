package com.halfacode.travelagency.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String iataCode;
    private int iataPrefix;
    private int iataAccounting;
    private String icaoCode;
    private String callsign;
    private String countryCode;
    private int iosaRegistered;
    private int isScheduled;
    private int isPassenger;
    private int isCargo;
    private int isInternational;
    private int totalAircrafts;
    private int averageFleetAge;
    private int accidentsLast5Years;
    private int crashesLast5Years;
    private String website;
    private String facebook;
    private String twitter;
    private String instagram;
    private String linkedin;
    private String slug;

    // Constructors, getters/setters, etc.
}