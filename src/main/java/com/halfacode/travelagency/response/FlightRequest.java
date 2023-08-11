package com.halfacode.travelagency.response;

import lombok.Data;

@Data
public class FlightRequest {
    private String lang;
    private String currency;
    private int time;
    private String id;
    private String server;
    private String host;
    private int pid;
    private Key key;

}
