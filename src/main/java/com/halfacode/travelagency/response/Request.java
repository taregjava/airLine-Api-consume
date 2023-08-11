package com.halfacode.travelagency.response;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
@Data
public class Request {
    private String lang;
    private String currency;
    private Integer time;
    private String id;
    private String server;
    private String host;
    private Integer pid;
    private Key key;
    private Params params;
    private Integer version;
    private String method;
  //  private Client client;
}
