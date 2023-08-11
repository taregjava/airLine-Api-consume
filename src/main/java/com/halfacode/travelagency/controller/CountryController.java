package com.halfacode.travelagency.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.halfacode.travelagency.dto.CountryDTO;
import com.halfacode.travelagency.entity.CountryEntity;
import com.halfacode.travelagency.repoistory.CountryRepository;
import com.halfacode.travelagency.response.CountryResponse;
import com.halfacode.travelagency.response.CountryResponseDTO;
import com.halfacode.travelagency.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @Autowired
    private  RestTemplate restTemplate;

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping("/fetch-and-save-countries")
    public List<CountryDTO> fetchAndSaveCountries() {

        return countryService.fetchAndSaveCountries();
    }
    private CountryEntity convertToCountryEntity(CountryResponseDTO responseDTO) {
        CountryEntity entity = new CountryEntity();
        entity.setCode(responseDTO.getCode());
        entity.setName(responseDTO.getName());
        return entity;
    }
   /* @GetMapping("/country-info")
    public CountryEntity getCountryInfo() {
        return countryService.getCountryInfo();
    }

    @GetMapping("/save-country")
    public String saveCountryInfo() {
        countryService.saveCountryInfo();
        return "Country information saved successfully";
    }*/
}