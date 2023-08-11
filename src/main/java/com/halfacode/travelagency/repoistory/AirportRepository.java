package com.halfacode.travelagency.repoistory;

import com.halfacode.travelagency.entity.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, String> {

}
