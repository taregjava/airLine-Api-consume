package com.halfacode.travelagency.service;

import com.halfacode.travelagency.dto.NearbyResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NearbyAirportService {

    @Autowired
    private AirLabsApiService airLabsApiService;

  /*  public NearbyResponseDTO getNearbyAirports(Double lat, Double lng, Double distance) {
        return airLabsApiService.fetchNearbyAirports(lat, lng, distance);
    }*/
}