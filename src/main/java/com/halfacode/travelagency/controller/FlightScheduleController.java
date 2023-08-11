package com.halfacode.travelagency.controller;

import com.halfacode.travelagency.response.FlightScheduleResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/flightSchedule")
public class FlightScheduleController {
    @Value("${airlabs.api.schedulesApiUrl}")
    private String schedulesApiUrl;

    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private FlightScheduleResponseDTO cachedFlightScheduleResponse; // Store the response for caching

    @GetMapping("/fetch-and-save-schedules")
    public ResponseEntity<String> fetchAndSaveSchedules() {
        FlightScheduleResponseDTO response = restTemplate.getForObject(schedulesApiUrl, FlightScheduleResponseDTO.class);
        cachedFlightScheduleResponse = response; // Save the response
        return ResponseEntity.ok("Schedules fetched and saved.");
    }

    @GetMapping("/get-saved-schedules")
    public ResponseEntity<FlightScheduleResponseDTO> getSavedSchedules() {
        if (cachedFlightScheduleResponse != null) {
            return ResponseEntity.ok(cachedFlightScheduleResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
