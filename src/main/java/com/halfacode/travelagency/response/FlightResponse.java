package com.halfacode.travelagency.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.halfacode.travelagency.dto.FlightDTO;
import lombok.Data;

@Data
public class FlightResponse {

    private FlightDTO[] response; // This is the array of flights

    // Define the getter and setter for the 'response' field

    // Add the 'request' field along with its getter and setter
    private Object request; // Change 'Object' to the appropriate type if available
    private String terms;

}