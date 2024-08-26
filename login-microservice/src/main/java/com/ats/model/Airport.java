package com.ats.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Airport {
    private Airport(){

    }

    private String countryCode;
    private String airportName;
    private String location;
    private String airportId;

    public static Airport getInstance(){
        return new Airport();
    }
}
