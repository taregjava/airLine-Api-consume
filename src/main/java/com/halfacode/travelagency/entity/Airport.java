package com.halfacode.travelagency.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true) // Ignore unknown properties during deserialization
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airport {
    @Id

    @Column(name = "iata_code") // This annotation specifies the column name
    private String iataCode;
    private String name;
    private String icaoCode;
    private Double lat;
    private Double lng;
    private Integer alt;
    private String city;
    private String cityCode;
    private String unLocode;
    private String timezone;
    private String countryCode;
    private String phone;
    private String website;
    private String facebook;
    private String instagram;
    private String linkedin;
    private String twitter;
    @Transient // Exclude from database mapping
    private AirportNames names; // Assuming it's an array of names
    private Integer runways;
    private Integer departures;
    private Integer connections;
    private Boolean isMajor;
    private Integer isInternational;
    private String slug;

    @Override
    public String toString() {
        return "Airport{" +
                "iataCode='" + iataCode + '\'' +
                ", name='" + name + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", alt=" + alt +
                ", city='" + city + '\'' +
                ", cityCode='" + cityCode + '\'' +
                ", unLocode='" + unLocode + '\'' +
                ", timezone='" + timezone + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", facebook='" + facebook + '\'' +
                ", instagram='" + instagram + '\'' +
                ", linkedin='" + linkedin + '\'' +
                ", twitter='" + twitter + '\'' +
                ", names=" + names +
                ", runways=" + runways +
                ", departures=" + departures +
                ", connections=" + connections +
                ", isMajor=" + isMajor +
                ", isInternational=" + isInternational +
                ", slug='" + slug + '\'' +
                '}';
    }
}
