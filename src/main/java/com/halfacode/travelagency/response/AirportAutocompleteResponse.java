package com.halfacode.travelagency.response;

import com.halfacode.travelagency.dto.AirportDTO;
import com.halfacode.travelagency.dto.CityDTO;
import com.halfacode.travelagency.dto.CountryDTO;
import lombok.Data;

import java.util.List;

@Data
public class AirportAutocompleteResponse {

    private List<CountryDTO> countries;
    private List<CityDTO> cities;
    private List<AirportDTO> airports;
    private List<CityDTO> cities_by_airports;
    private List<CityDTO> cities_by_countries;
    private List<AirportDTO> airports_by_cities;
    private List<AirportDTO> airports_by_countries;
}
