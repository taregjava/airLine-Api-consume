package com.halfacode.travelagency.response;


import com.halfacode.travelagency.dto.FlightDTO;
import lombok.Data;

import java.util.List;

@Data
public class FlightResponseDTO {
    private List<FlightDTO> response;

    // Getter and Setter
}

