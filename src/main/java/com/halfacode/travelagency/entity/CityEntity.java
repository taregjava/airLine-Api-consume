package com.halfacode.travelagency.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "city") // Specify the actual table name if needed
public class CityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Or any suitable data type for your primary key
    private String cityCode;
    private String name;
    private Double lat;
    private Double lng;
    private String countryCode;
}
