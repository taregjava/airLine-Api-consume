package com.halfacode.travelagency.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/nearby")
public class NearbyAirportController {

  /*  @Autowired
    private NearbyAirportService nearbyAirportService;

    @GetMapping
    public ResponseEntity<NearbyResponseDTO> getNearbyAirports(
            @RequestParam Double lat,
            @RequestParam Double lng,
            @RequestParam Double distance
    ) {
        NearbyResponseDTO responseDTO = nearbyAirportService.getNearbyAirports(lat, lng, distance);
        return ResponseEntity.ok(responseDTO);
    }*/
}