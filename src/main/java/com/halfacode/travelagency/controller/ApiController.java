package com.halfacode.travelagency.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.halfacode.travelagency.dto.FlightDTO;
import com.halfacode.travelagency.response.FlightResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class ApiController {
    @Value("${airlabs.api.urlFlight}")
    private String urlFlight;

    private final ObjectMapper objectMapper = new ObjectMapper();
    @GetMapping("/flights")
    public List<FlightDTO> getFlights() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(urlFlight);

        try {
            org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(httpResponse.getEntity());

            // Deserialize the JSON response using FlightResponse
            FlightResponse flightResponse = objectMapper.readValue(responseBody, FlightResponse.class);
            return List.of(flightResponse.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
  /*  @GetMapping("/flights")
    public List<FlightDTO> getFlights() {


        HttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(urlFlight);

        try {
            org.apache.http.HttpResponse httpResponse = httpClient.execute(httpGet);
            String responseBody = EntityUtils.toString(httpResponse.getEntity());

            // Deserialize the JSON response using FlightResponse
            FlightResponse flightResponse = objectMapper.readValue(responseBody, FlightResponse.class);
            return List.of(flightResponse.getResponse());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }*/
}