package com.halfacode.travelagency.repoistory;

import com.halfacode.travelagency.entity.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {
    // You can add custom query methods here if needed
}