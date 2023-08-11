package com.halfacode.travelagency.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halfacode.travelagency.entity.Airport;
import com.halfacode.travelagency.entity.AirportNames;
import com.halfacode.travelagency.repoistory.AirportRepository;
import com.halfacode.travelagency.response.AirportAutocompleteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class AirportService {
    @Value("${airlabs.api.urlquery}")
    private String urlquery;


    private final RestTemplate restTemplate;

    @Autowired
    public AirportService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public AirportAutocompleteResponse getAutocompleteData(String query) {
        ResponseEntity<AirportAutocompleteResponse> responseEntity = restTemplate.getForEntity(urlquery, AirportAutocompleteResponse.class, query);
        return responseEntity.getBody();
    }
}

   /* @Autowired
    private AirportRepository airportRepository;

    private final String AIRLABS_API_URL = "https://airlabs.co/api/v9/airports";

    @Value("${airlabs.api.key}")
    private String apiKey;

    public void saveAirportFromApi() {
        String iataCode = "CDG"; // Example IATA code
        String apiUrl = AIRLABS_API_URL + "?iata_code=" + iataCode + "&api_key=" + apiKey;

        RestTemplate restTemplate = new RestTemplate();
        // Fetch data as a Map (assuming the API returns an object)
        Map<String, Object> airportData = restTemplate.getForObject(apiUrl, Map.class);

        if (airportData != null) {
            ObjectMapper objectMapper = new ObjectMapper();
            Airport airport = objectMapper.convertValue(airportData, Airport.class);

            // Handle the "names" field separately
            Map<String, String> namesData = (Map<String, String>) airportData.get("names");
            if (namesData != null) {
                AirportNames names = objectMapper.convertValue(namesData, AirportNames.class);
                airport.setNames(names);
            }

            // Set the iataCode field
            String iataCodeFromData = (airportData.get("iata_code") != null) ? airportData.get("iata_code").toString() : null;
            airport.setIataCode(iataCodeFromData);

            airportRepository.save(airport);
        }
    }*/
