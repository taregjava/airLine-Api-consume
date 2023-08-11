package com.halfacode.travelagency.service;
import com.halfacode.travelagency.dto.CityDTO;
import com.halfacode.travelagency.dto.CountryDTO;
import com.halfacode.travelagency.entity.CityEntity;
import com.halfacode.travelagency.entity.CountryEntity;
import com.halfacode.travelagency.repoistory.CityRepository;
import com.halfacode.travelagency.repoistory.CountryRepository;
import com.halfacode.travelagency.response.CityResponse;
import com.halfacode.travelagency.response.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CityService {

    @Value("${airlabs.api.key}")
    private String apiKey;

    @Value("${airlabs.api.urlCity}")
    private String apiUrlCity;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final CityRepository cityRepository;

    @Autowired
    public CityService(RestTemplate restTemplate, CityRepository cityRepository) {
        this.restTemplate = restTemplate;
        this.cityRepository = cityRepository;
    }

    public List<CityDTO> fetchAndSaveCities() {
        String apiUrlWithKey = apiUrlCity + "?api_key=" + apiKey;
        CityResponse response = restTemplate.getForObject(apiUrlWithKey, CityResponse.class);
        System.out.println("API Response: " + response);

        List<CityDTO> cities = response.getResponse();

        // Save cities in the database
        List<CityEntity> cityEntities = cities.stream()
                .map(this::convertToCityEntity)
                .collect(Collectors.toList());
        cityRepository.saveAll(cityEntities);

        return cities;
    }

    private CityEntity convertToCityEntity(CityDTO city) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setName(city.getName());
        cityEntity.setCityCode(city.getCityCode());
        cityEntity.setLat(city.getLat());
        cityEntity.setLng(city.getLng());
        cityEntity.setCountryCode(city.getCountryCode());
        return cityEntity;
    }

}