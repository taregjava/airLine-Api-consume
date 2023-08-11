package com.halfacode.travelagency.dto;

import lombok.Data;

@Data
public class AirportDTO {

    private String country_code;
    private String iata_code;
    private double lng;
    private String city;
    private String timezone;
    private String name;
    private String city_code;
    private String slug;
    private double lat;
    private int popularity;


   /* @Override
    public String toString() {
        return "AirportDTO{" +
                "name='" + name + '\'' +
                ", iataCode='" + iataCode + '\'' +
                ", icaoCode='" + icaoCode + '\'' +
                // Other fields...
                '}';
    }*/

}
