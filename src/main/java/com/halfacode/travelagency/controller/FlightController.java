package com.halfacode.travelagency.controller;
import com.halfacode.travelagency.response.FlightResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.halfacode.travelagency.dto.FlightDTO;
import com.halfacode.travelagency.entity.FlightEntity;
import com.halfacode.travelagency.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/flights")
public class FlightController {
    @Value("${airlabs.api.urlFlight}")
    private String urlFlight;

    @Autowired
    private FlightService flightService;
      private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    private FlightResponseDTO cachedFlightResponse; // Store the response for caching

    @GetMapping("/fetch-and-save-flights")
    public ResponseEntity<String> fetchAndSaveFlights() {
        FlightResponseDTO response = restTemplate.getForObject(urlFlight, FlightResponseDTO.class);
        cachedFlightResponse = response; // Save the response
        return ResponseEntity.ok("Flights fetched and saved.");
    }

    @GetMapping("/get-saved-flights")
    public ResponseEntity<FlightResponseDTO> getSavedFlights() {
        if (cachedFlightResponse != null) {
            return ResponseEntity.ok(cachedFlightResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   /* @PostMapping("/update")
    public ResponseEntity<String> updateFlights(@RequestParam String api_key) {
        try {
            List<FlightDTO> flightDTOs = List.of(flightService.fetchFlights());
            List<FlightEntity> flights = flightService.convertDTOToEntity(flightDTOs);
            flightService.saveFlights(flights);
            return ResponseEntity.ok("Flights updated successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating flights");
        }
    }*/

  /*  private List<FlightEntity> convertDTOsToEntities(List<FlightDTO> flightDTOs) {
        // Implement conversion logic from DTOs to entities
        // For example, you can use a mapper library like ModelMapper
        // or manually map the fields from DTOs to entities.
        // Return the list of FlightEntity objects.
    }*/
  /*  @GetMapping()
    public List<FlightEntity> getFlights() {
        FlightDTO[] flightDTOs = flightService.fetchFlights();  // Fetch FlightDTO data using the flightService

        // Convert FlightDTOs to FlightEntity using the flightService
        return Arrays.stream(flightDTOs)
                .map(flightService::convertDTOToEntity)
                .collect(Collectors.toList());  // Collect the converted entities into a list
    }*/
  @GetMapping("/{flightNumber}")
  public ResponseEntity<FlightDTO> getFlightByNumber(@PathVariable String flightNumber) {
      FlightDTO flight = flightService.getFlightByNumber(flightNumber);

      if (flight != null) {
          return ResponseEntity.ok(flight);
      } else {
          return ResponseEntity.notFound().build();
      }
  }
}