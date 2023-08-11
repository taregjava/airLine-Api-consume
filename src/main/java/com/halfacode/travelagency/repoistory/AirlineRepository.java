package com.halfacode.travelagency.repoistory;

import com.halfacode.travelagency.entity.Airline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirlineRepository extends JpaRepository<Airline, Long> {
    // Custom query methods if needed
}
