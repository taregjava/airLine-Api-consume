package com.halfacode.travelagency.response;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Root {
    private Request request;
    private List<Response> response = new ArrayList<Response>();
    private String terms;
}
