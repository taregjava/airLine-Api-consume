package com.halfacode.travelagency.controller;

import com.halfacode.travelagency.dto.CityDTO;
import com.halfacode.travelagency.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cities")
public class CityController {

    private final CityService cityService;

    @Autowired
    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/fetch-and-save")
    public ResponseEntity<List<CityDTO>> fetchAndSaveCities() {
        List<CityDTO> cities = cityService.fetchAndSaveCities();
        return ResponseEntity.ok(cities);
    }
}
