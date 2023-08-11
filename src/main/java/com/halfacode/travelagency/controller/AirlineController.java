package com.halfacode.travelagency.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.halfacode.travelagency.dto.FlightDTO;
import com.halfacode.travelagency.entity.Airline;
import com.halfacode.travelagency.entity.FlightEntity;
import com.halfacode.travelagency.repoistory.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.http.HttpClient;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/api/airlines")
public class AirlineController {
  /*  @Autowired
    private AirlineRepository airlineRepository;


    @PostMapping("/update")
    public ResponseEntity<String> updateAirlines(@RequestParam(required = true) String api_key,
                                                 @RequestParam(required = false) String iata_code,
                                                 @RequestParam(required = false) Integer iata_prefix,
                                                 @RequestParam(required = false) Integer iata_accounting,
                                                 @RequestParam(required = false) String icao_code) {
        String apiUrl = "";

        // Construct the query parameters based on the provided parameters
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("api_key", api_key);

        if (iata_code != null) {
            builder.queryParam("iata_code", iata_code);
        }
        if (iata_prefix != null) {
            builder.queryParam("iata_prefix", iata_prefix);
        }
        if (iata_accounting != null) {
            builder.queryParam("iata_accounting", iata_accounting);
        }
        if (icao_code != null) {
            builder.queryParam("icao_code", icao_code);
        }

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(builder.build().toUri())
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();

            // Parse the JSON response and convert it to a List<Airline>
            ObjectMapper objectMapper = new ObjectMapper();
            List<Airline> airlines = objectMapper.readValue(responseBody, new TypeReference<List<Airline>>() {});

            // Save the list of airlines to the database
            airlineRepository.saveAll(airlines);

            return ResponseEntity.ok("Airlines updated successfully");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating airlines");
        }
    }*/
   /* @PostMapping("/update")
    public ResponseEntity<String> updateFlights(@RequestParam String api_key) {
        try {
            List<FlightDTO> flightDTOs = flightService.fetchAndMapFlights(api_key);
            List<FlightEntity> flights = flightService.convertDTOsToEntities(flightDTOs);
            flightService.saveFlights(flights);
            return ResponseEntity.ok("Flights updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating flights");
        }
    }*/
}