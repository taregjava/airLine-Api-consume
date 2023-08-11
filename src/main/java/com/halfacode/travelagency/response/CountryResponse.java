package com.halfacode.travelagency.response;

import com.halfacode.travelagency.dto.CountryDTO;
import lombok.Data;

import java.util.List;

@Data
public class CountryResponse {
    private List<CountryDTO> response;

    // Getters and setters
}