package com.halfacode.travelagency.response;

import com.halfacode.travelagency.dto.CityDTO;

import java.util.List;

public class CityResponse {

    private List<CityDTO> response;

    public List<CityDTO> getResponse() {
        return response;
    }

    public void setResponse(List<CityDTO> response) {
        this.response = response;
    }
}
