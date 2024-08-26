package com.ats.airport_microservice.model;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class AirportDTO {
    private AirportDTO(){

    }

    private String countryCode;
    private String airportName;
    private String location;
    private String airportId;

    public static AirportDTO getInstance(){
        return new AirportDTO();
    }
}
