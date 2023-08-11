package com.halfacode.travelagency.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class CountryEntity {
    @Id
    private String code;
    private String name;

}
