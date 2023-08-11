package com.halfacode.travelagency.service;

import com.halfacode.travelagency.dto.CountryDTO;
import com.halfacode.travelagency.entity.CountryEntity;
import com.halfacode.travelagency.repoistory.CountryRepository;
import com.halfacode.travelagency.response.CountryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryService {

    @Value("${airlabs.api.url}")
    private String apiUrl;

    @Value("${airlabs.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    private final CountryRepository countryRepository;
    @Autowired
    public CountryService(RestTemplate restTemplate, CountryRepository countryRepository) {
        this.restTemplate = restTemplate;
        this.countryRepository = countryRepository;
    }

    public List<CountryDTO> fetchAndSaveCountries() { // No URL parameter needed
        String fullApiUrl = apiUrl + "api_key=" + apiKey; // Append the API key to the URL
        CountryResponse response = restTemplate.getForObject(fullApiUrl, CountryResponse.class);

        List<CountryDTO> countries = response.getResponse();

        // Save countries in the database
        List<CountryEntity> countryEntities = countries.stream()
                .map(this::convertToCountryEntity)
                .collect(Collectors.toList());
        countryRepository.saveAll(countryEntities);

        return countries;
    }

    private CountryEntity convertToCountryEntity(CountryDTO country) {
        CountryEntity countryEntity = new CountryEntity();
        countryEntity.setCode(country.getCode());
        countryEntity.setName(country.getName());
        return countryEntity;
    }
}

   /* private final String apiUrl = "";

    @Autowired
    private CountryRepository countryRepository;
    public CountryEntity getCountryInfo() {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(apiUrl);

        try {
            org.apache.http.HttpResponse response = httpClient.execute(request);
            String responseBody = EntityUtils.toString(response.getEntity());
            System.out.println("API Response: " + responseBody);

            ObjectMapper objectMapper = new ObjectMapper();
            CountryEntity[] countries = objectMapper.readValue(responseBody, CountryEntity[].class);

            if (countries != null && countries.length > 0) {
                return countries[0];
            }
        } catch (IOException e) {
            // Handle exception if needed
        }

        return null;
    }
    @Transactional
    public void saveCountryInfo() {
        CountryEntity country = getCountryInfo();
        if (country != null) {
            countryRepository.save(country);
        }
    }
}*/