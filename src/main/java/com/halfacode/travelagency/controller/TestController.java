package com.halfacode.travelagency.controller;
import com.halfacode.travelagency.entity.TaxData;
import com.halfacode.travelagency.repoistory.TaxDataRepository;
import com.halfacode.travelagency.test.LabsAirApiResponseDTO;
import com.halfacode.travelagency.test.LabsAirTaxDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class TestController {

    @Value("${airlabs.api.urlTaxes}")
    private String urlTaxes;

    @Autowired
    private TaxDataRepository taxDataRepository;


        private final RestTemplate restTemplate = new RestTemplate();
        private final ObjectMapper objectMapper = new ObjectMapper();

        private LabsAirApiResponseDTO cachedResponse; // Use DTO

        @GetMapping("/fetch-and-save")
        public ResponseEntity<String> fetchAndSaveData() {
            LabsAirApiResponseDTO response = restTemplate.getForObject(urlTaxes, LabsAirApiResponseDTO.class);
            cachedResponse = response; // Save the DTO response
            return ResponseEntity.ok("Data fetched and saved.");
        }

        @GetMapping("/get-saved-data")
        public ResponseEntity<LabsAirApiResponseDTO> getSavedData() {
            if (cachedResponse != null) {
                return ResponseEntity.ok(cachedResponse);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

    @PostMapping("/save-to-db")
    public ResponseEntity<String> saveToDatabase() {
        if (cachedResponse != null) {
            for (LabsAirTaxDTO taxDTO : cachedResponse.getResponse()) {
                TaxData taxData = new TaxData();
                taxData.setCode(taxDTO.getCode());
                taxData.setName(taxDTO.getName());
                taxDataRepository.save(taxData);
            }
            return ResponseEntity.ok("Data saved to the database.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    }
