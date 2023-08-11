package com.halfacode.travelagency.response;
import lombok.Data;

@Data
public class Key {
    private Integer id;
    private String apiKey;
    private String type;
    private String expired;
    private String registered;
    private Integer limitsByHour;
    private Integer limitsByMinute;
    private Integer limitsByMonth;
    private Integer limitsTotal;
}
