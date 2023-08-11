package com.halfacode.travelagency.dto;

import lombok.Data;

@Data
public class CityDTO {

    private String name;
    private String cityCode;
    private Double lat;
    private Double lng;
    private String countryCode;
}
