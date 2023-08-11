package com.halfacode.travelagency.mapper;

import com.halfacode.travelagency.dto.FlightDTO;
import com.halfacode.travelagency.entity.FlightEntity;
import org.springframework.stereotype.Component;

@Component
public class FlightMapper {

    /*public FlightEntity toEntity(FlightDTO flightDto) {
        return FlightEntity.builder()
                .time(flightDto.getTime())
                .flightCode(flightDto.getFlightCode())
                .destination(flightDto.getDestination())
                .status(flightDto.getStatus())
                .build();
    }*/

/*    public FlightDTO toDto(FlightEntity flightEntity) {
        return FlightDTO.builder()
                .time(flightEntity.getTime())
                .flightCode(flightEntity.getFlightCode())
                .destination(flightEntity.getDestination())
                .status(flightEntity.getStatus())
                .build();
    }*/
}