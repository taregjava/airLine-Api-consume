package com.halfacode.travelagency.response;

import lombok.Data;

@Data
public class Karma {
    private Boolean isBlocked;
    private Boolean isCrawler;
    private Boolean isBot;
    private Boolean isFriend;
    private Boolean isRegular;
}
