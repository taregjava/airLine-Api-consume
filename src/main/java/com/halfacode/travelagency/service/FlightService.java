package com.halfacode.travelagency.service;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.halfacode.travelagency.dto.FlightDTO;
import com.halfacode.travelagency.entity.FlightEntity;
import com.halfacode.travelagency.repoistory.FlightRepository;
import com.halfacode.travelagency.response.FlightResponse;
import com.halfacode.travelagency.response.FlightResponseDTO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightService {

   // private final String apiUrl = "https://airlabs.co/api/v9/flights"; // Define the API URL here
    private final String apiUrl = "https://airlabs.co/api/v9/flights?api_key=f32fe9c6-5926-4f1c-b1bf-93d01e2d6ca4";

    @Value("${airlabs.api.key}")
    private String apiKey;

    private final FlightRepository flightRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();
    @Autowired
    public FlightService(FlightRepository flightRepository, RestTemplate restTemplate) {
        this.flightRepository = flightRepository;
        this.restTemplate = restTemplate;
    }

    public List<FlightDTO> fetchFlights(String departureAirport, String arrivalAirport, LocalDate departureDate) {
        String apiUrl = "https://airlabs.co/api/v9/flights";
        HttpHeaders headers = new HttpHeaders();
        headers.set("api_key", apiKey);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(apiUrl)
                .queryParam("dep_icao", departureAirport)
                .queryParam("arr_icao", arrivalAirport)
                .queryParam("date", departureDate.toString());

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<FlightDTO[]> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                FlightDTO[].class);

        if (response.getStatusCode() == HttpStatus.OK) {
            return Arrays.asList(response.getBody());
        } else {
            throw new RuntimeException("Error fetching flight data from API");
        }
    }

    public void saveFlights(List<FlightEntity> flights) {
        flightRepository.saveAll(flights);
    }
    /*public FlightDTO[] fetchFlights() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("api_key", apiKey); // Make sure apiKey is correctly set
        HttpEntity<?> entity = new HttpEntity<>(headers);

        // Add debugging logs to the RestTemplate
        restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                // Log the response details
                System.out.println("Response Status Code: " + response.getStatusCode());
                System.out.println("Response Body: " + StreamUtils.copyToString(response.getBody(), StandardCharsets.UTF_8));

                return super.hasError(response);
            }
        });

        ResponseEntity<FlightResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                FlightResponse.class); // Use FlightResponse.class for deserialization

        if (response.getBody() != null && response.getBody().getResponse() != null) {
            return response.getBody().getResponse(); // Access the response array within the wrapper
        } else {
            throw new RuntimeException("Response body or response array is null");
        }
    }*/

   /* @GetMapping("/flights")
    public String getFlights() {
        String apiUrl = "flightapi";

        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(apiUrl);

        try {
            org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(httpResponse.getEntity());
            return responseBody;
        } catch (Exception e) {
            e.printStackTrace();
            return "Error occurred: " + e.getMessage();
        }
    }
}*/


   public FlightDTO getFlightByNumber(String flightNumber) {
       ResponseEntity<FlightResponseDTO> responseEntity = restTemplate.getForEntity(apiUrl, FlightResponseDTO.class);
       FlightResponseDTO responseWrapper = responseEntity.getBody();

       if (responseWrapper != null && responseWrapper.getResponse() != null) {
           List<FlightDTO> response = responseWrapper.getResponse();

           for (FlightDTO flight : response) {
               String flightNumberFromResponse = flight.getFlight_number();
               if (flightNumberFromResponse != null && flightNumberFromResponse.equals(flightNumber)) {
                   return flight;
               }
           }
       }

       return null; // Flight not found
   }


    public FlightDTO[] fetchFlights() {
        try {
            HttpClient httpClient = HttpClients.createDefault();

            HttpGet httpGet = new HttpGet(apiUrl);
            httpGet.addHeader(HttpHeaders.AUTHORIZATION, "api_key " + apiKey);

            HttpResponse response = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(response.getEntity());

            FlightResponse flightResponse = objectMapper.readValue(responseBody, FlightResponse.class);



            if (flightResponse.getResponse() != null) {
                return flightResponse.getResponse();
            } else {
                throw new RuntimeException("Response array is null");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error fetching flights: " + e.getMessage(), e);
        }
    }
   /* public FlightDTO[] fetchFlights() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("api_key", apiKey); // Make sure apiKey is correctly set
        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<FlightResponse> response = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                entity,
                FlightResponse.class); // Use FlightResponse.class for deserialization

        if (response.getBody() != null && response.getBody().getResponse() != null) {
            return response.getBody().getResponse(); // Access the response array within the wrapper
        } else {
            throw new RuntimeException("Response body or response array is null");
        }
    }*/
    public FlightEntity convertDTOToEntity(FlightDTO flightDTO) {
        return FlightEntity.builder()
                .hex(flightDTO.getHex())
                .registrationNumber(flightDTO.getReg_number())
                .flag(flightDTO.getFlag())
                .latitude(flightDTO.getLat())
                .longitude(flightDTO.getLng())
                .altitude((int) flightDTO.getAlt())
                .direction(flightDTO.getDir())
                .speed(flightDTO.getSpeed())
                .verticalSpeed(flightDTO.getV_speed())
                .squawk(flightDTO.getSquawk())
                .flightNumber(flightDTO.getFlight_number())
                .flightIcaoCode(flightDTO.getFlight_icao())
                .flightIataCode(flightDTO.getFlight_iata())
                .departureIcaoCode(flightDTO.getDep_icao())
                .departureIataCode(flightDTO.getDep_iata())
                .arrivalIcaoCode(flightDTO.getArr_icao())
                .arrivalIataCode(flightDTO.getArr_iata())
                .airlineIcaoCode(flightDTO.getAirline_icao())
                .airlineIataCode(flightDTO.getAirline_iata())
                .aircraftIcaoCode(flightDTO.getAircraft_icao())
                .updated(flightDTO.getUpdated())
                .status(flightDTO.getStatus())
                .build();
    }

    public List<FlightEntity> convertDTOsToEntities(List<FlightDTO> flightDTOs) {
        return flightDTOs.stream()
                .map(this::convertDTOToEntity)
                .collect(Collectors.toList());
    }
}