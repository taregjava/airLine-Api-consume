package com.halfacode.travelagency.repoistory;
import com.halfacode.travelagency.entity.TaxData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaxDataRepository extends JpaRepository<TaxData, Long> {
    // You can add custom query methods here if needed
}