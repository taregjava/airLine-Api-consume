package com.halfacode.travelagency.controller;

import com.halfacode.travelagency.response.AirportAutocompleteResponse;
import com.halfacode.travelagency.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/airports")
public class AirportController {

  /*  @Autowired
    private AirportService airportService;

    @GetMapping("/{iataCode}")
    public ResponseEntity<AirportDTO> getAirportByIataCode(@PathVariable String iataCode) {
        AirportDTO airportDTO = airportService.getAirportByIataCode(iataCode);
        return ResponseEntity.ok(airportDTO);
    }*/

    @Autowired
    private AirportService airportService;

    @GetMapping("/{query}")
    public ResponseEntity<AirportAutocompleteResponse> getAutocompleteData(@PathVariable String query) {
        AirportAutocompleteResponse response = airportService.getAutocompleteData(query);
        if (response != null) {
            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    /*@GetMapping("/save-airport")
    public String saveAirport() {
        airportService.saveAirportFromApi();
        return "Airport data saved!";
    }*/
}