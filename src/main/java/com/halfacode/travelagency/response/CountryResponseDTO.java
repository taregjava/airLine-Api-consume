package com.halfacode.travelagency.response;

import com.halfacode.travelagency.dto.CountryDTO;
import lombok.Data;

@Data
public class CountryResponseDTO {
    private String code;
    private String code3;
    private String name;

   /* public CountryDTO toCountryDTO() {
        return new CountryDTO(code, name);
    }*/
}