package com.halfacode.travelagency.repoistory;

import com.halfacode.travelagency.entity.FlightEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<FlightEntity, Long> {
    // Add custom query methods if needed
}